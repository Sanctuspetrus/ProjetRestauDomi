import pizzas from 'api/pizzas'
import ingredients from 'api/ingredients'
import * as types from 'store/mutations'

// initial state
// shape: [{ id, quantity }]
const state = {
	allPizzas: [],
	allIngredients: [],
	allDoughs: [],
	newPizza: {
		ingredients: []
	}
}

// getters
const getters = {
	allPizzas: state => state.allPizzas,
	allIngredients: state => state.allIngredients,
	allDoughs: state => state.allDoughs,
	ingPizza: state => state.newPizza.ingredients
}

// actions
const actions = {
	getAllPizzas ({ commit }) {
		pizzas.getPizzas(pizzas => {
			commit(types.RECEIVE_PIZZAS, { pizzas })
		})
		ingredients.getIngredients(data => {
			commit(types.RECEIVE_INGREDIENTS, { ingredients: data.ingredients })
			commit(types.RECEIVE_DOUGHS, { doughs: data.doughs })
		})
	},
	addIngredient({ commit }, ingredient) {
		if (state.allIngredients.find(ing => ing.id === ingredient) !== undefined) {
			commit(types.ADD_INGREDIENT, {ingredient})
		} else {
			var error = { decription: "can't add ingredient" }
			commit(types.SET_ERROR, {error})
		}
	}
}

// mutations
const mutations = {
	[types.RECEIVE_INGREDIENTS] (state, {ingredients}) {
		state.allIngredients = ingredients
	},
	[types.RECEIVE_DOUGHS] (state, {doughs}) {
		state.allDoughs = doughs
	},
	[types.RECEIVE_PIZZAS] (state, {pizzas}) {
		state.allPizzas = pizzas
	},
	[types.ADD_INGREDIENT] (state, {ingredient}) {
		state.newPizza.ingredients.push(ingredient)
	}
}

export default {
	state,
	getters,
	actions,
	mutations
}
