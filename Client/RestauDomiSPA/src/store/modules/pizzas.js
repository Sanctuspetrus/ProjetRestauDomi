import pizzas from 'api/pizzas'
import * as types from 'store/mutations'

// initial state
// shape: [{ id, quantity }]
const state = {
	allPizzas: []
}

// getters
const getters = {
	allPizzas: state => state.allPizzas
}

// actions
const actions = {
	getAllPizzas ({ commit }) {
		pizzas.getPizzas(pizzas => {
			commit(types.RECEIVE_PIZZAS, { pizzas })
		})
	}
}

// mutations
const mutations = {
	[types.RECEIVE_PIZZAS] (state, {pizzas}) {
		state.allPizzas = pizzas
	},

	[types.CHECKOUT_FAILURE] (state, { savedCartItems }) {
		// rollback to the cart saved before sending the request
		state.added = savedCartItems
		state.checkoutStatus = 'failed'
	}
}

export default {
	state,
	getters,
	actions,
	mutations
}
