import membres from 'api/membres'
import ingredients from 'api/ingredients'
import * as types from 'store/mutations'

// initial state
// shape: [{ id, quantity }]
const state = {
	allMembres: []
}

// getters
const getters = {
	allMembres: state => state.allPizzas
}

// actions
const actions = {
	getAllMembres ({ commit }) {
		membres.getMembres(membres => {
			commit(types.RECEIVE_MEMBRES, { membres })
		})
	},
	addPizzaToMembre({ commit }, idPizza, idMembre) {
		commit(types.ADD_PIZZA_TO_MEMBRE, {idPizza, idMembre})
	},
	addFavoriToMembre({ commit }, idPizza, idMembre) {
		commit(types.ADD_FAVORI_TO_MEMBRE, {idPizza, idMembre})
	},
	removePizzaFromMembre({ commit }, idPizza, idMembre) {
		commit(types.REMOVE_PIZZA_FROM_MEMBRE, {idPizza, idMembre})
	},
	removeFavoriFromMembre({ commit }, idPizza, idMembre) {
		commit(types.REMOVE_FAVORI_FROM_MEMBRE, {idPizza, idMembre})
	}
}

// mutations
const mutations = {
	[types.RECEIVE_MEMBRES] (state, {membres}) {
		state.allMembres = membres
	},
	[types.ADD_PIZZA_TO_MEMBRE] (state, {idPizza, idMembre}) {
		var membre = state.allMembres.find(membre => membre.id === idMembre)
		membre.pizzas.push(idPizza)
	},
	[types.ADD_FAVORI_TO_MEMBRE] (state, {idPizza, idMembre}) {
		var membre = state.allMembres.find(membre => membre.id === idMembre)
		membre.favoris.push(idPizza)
	},
	[types.REMOVE_PIZZA_FROM_MEMBRE] (state, {idPizza, idMembre}) {
		var membre = state.allMembres.find(membre => membre.id === idMembre)
		var index = membre.pizzas.findIndex(idPizza)
		if (index !== -1) {
			membre.pizzas.splice(index, 1)
		}
	},
	[types.REMOVE_FAVORI_FROM_MEMBRE] (state, {idPizza, idMembre}) {
		var membre = state.allMembres.find(membre => membre.id === idMembre)
		var index = membre.favoris.findIndex(idPizza)
		if (index !== -1) {
			membre.favoris.splice(index, 1)
		}
	}
}

export default {
	state,
	getters,
	actions,
	mutations
}
