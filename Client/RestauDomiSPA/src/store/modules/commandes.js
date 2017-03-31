import * as types from 'src/store/mutations'

// initial state
// shape: [{ pizza, amount }]
const state = {
	allCommandes: []
}

// getters
const getters = {
	allCommandes: state => state.allCommandes
}

// actions
const actions = {
	annulerCommande({ commit }, commande) {
		commit(types.ANNULER_COMMANDE, {commande})
	}
}

// mutations
const mutations = {
	[types.NOUVELLE_COMMANDE] (state, {commande}) {
		state.allCommandes.push(commande)
	},
	[types.ANNULER_COMMANDE] (state, {commande}) {
		console.log(commande)
		var index = state.allCommandes.findIndex(cmd => cmd.id === commande)
		if (index !== -1) {
			state.allCommandes.splice(index, 1)
		}
	}
}

export default {
	state,
	getters,
	actions,
	mutations
}
