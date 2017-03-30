import Vue from 'vue'
import Vuex from 'vuex'

import * as actions from 'store/actions'
import * as getters from 'store/getters'

import account from 'store/modules/account'
import pizzas from 'store/modules/pizzas'
import carts from 'store/modules/carts'

Vue.use(Vuex)

export default new Vuex.Store({
	actions,
	getters,
	modules: {
		account,
		pizzas,
		carts
	},
	mutations: {
		increment: state => state.count++,
		decrement: state => state.count--
	}
})
