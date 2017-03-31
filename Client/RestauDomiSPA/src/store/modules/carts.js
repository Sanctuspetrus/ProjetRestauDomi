// import pizzas from 'api/pizzas'
import * as types from 'src/store/mutations'

// initial state
// shape: [{ pizza, amount }]
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
	},
	commander({ commit }) {
		var commande = {
			id: Math.random().toString(36).substring(7),
			contenu: state.content
		}
		commit(types.NOUVELLE_COMMANDE, {commande})
		commit(types.VIDER_LE_PANIER)
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
	},
	[types.VIDER_LE_PANIER] (state) {
		state.content = []
	}
}

export default {
	state,
	getters,
	actions,
	mutations
}
