// import pizzas from 'api/pizzas'
import * as types from 'src/store/mutations'

// initial state
// shape: [{ id, quantity }]
const state = {
	content: []
}

// getters
const getters = {
	cartContent: state => state.content
}

// actions
const actions = {
	addPizzaToCart({ commit }, pizza) {
		commit(types.ADD_PIZZA_TO_CART, {pizza})
	},
	delPizzaFromCart({ commit }, pizza) {
		commit(types.DEL_PIZZA_FROM_CART, {pizza})
	}
}

// mutations
const mutations = {
	[types.ADD_PIZZA_TO_CART] (state, {pizza}) {
		var index = state.content.findIndex(item => item.pizza === pizza)
		if (index === -1) {
			state.content.push(
				{ pizza: pizza, amount: 1 }
			)
		} else {
			state.content[index].amount++
		}
	},
	[types.DEL_PIZZA_FROM_CART] (state, {pizza}) {
		var index = state.content.findIndex(item => (item.pizza === pizza))
		if (index >= 0) {
			if (state.content[index].amount > 1) {
				state.content[index].amount--
			} else {
				state.content.splice(index, 1)
			}
		}
	}
}

export default {
	state,
	getters,
	actions,
	mutations
}
