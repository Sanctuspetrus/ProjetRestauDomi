import membres from 'api/membres'
import * as types from 'store/mutations'

// initial state
// shape: [{ id, quantity }]
const state = {
	allMembres: [],
	currentMembre: {
		id: -1,
		login: 'jeanpeuplu',
		password: '1234',
		firstname: 'Jean',
		lastname: 'Peuplu',
		pizzas: [],
		favoris: []
	}
}

// getters
const getters = {
	allMembres: state => state.allMembres,
	currentMembre: state => state.currentMembre
}

// actions
const actions = {
	getAllMembres ({ commit }) {
		membres.getMembres(membres => {
			commit(types.RECEIVE_MEMBRES, { membres })
		})
	},
	connection({commit}, login, pwd) {
		return new Promise((resolve, reject) => {
			var membre = membres.connection(login, pwd).then(response => {
				commit(types.CONNECTED, membre)
				resolve()
			}, this).catch(error => {
				console.error(error)
				reject()
			})
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
	},
	setNewMembreLogin({commit}, login) {
		commit(types.SET_NEW_MEMBRE_LOGIN, {login})
	},
	setNewMembrePassword({commit}, pwd) {
		commit(types.SET_NEW_MEMBRE_PASSWORD, {pwd})
	},
	setNewMembreFirstName({commit}, first) {
		commit(types.SET_NEW_MEMBRE_FIRST_NAME, {first})
	},
	setNewMembreLastName({commit}, last) {
		commit(types.SET_NEW_MEMBRE_LAST_NAME, {last})
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
	},
	[types.SET_NEW_MEMBRE_LOGIN] (state, {login}) {
		state.currentMembre.login = login
	},
	[types.SET_NEW_MEMBRE_PASSWORD] (state, {pwd}) {
		state.currentMembre.password = pwd
	},
	[types.SET_NEW_MEMBRE_FIRST_NAME] (state, {first}) {
		state.currentMembre.firstname = first
	},
	[types.SET_NEW_MEMBRE_LAST_NAME] (state, {last}) {
		state.currentMembre.lastname = last
	}
}

export default {
	state,
	getters,
	actions,
	mutations
}
