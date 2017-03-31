import * as types from 'store/mutations'

// initial state
// shape: [{ id, quantity }]
const state = {
	error: null
}

// getters
const getters = {
	error: state => state.error
}

// actions
const actions = {
	setError({commit}, error) { commit(types.SET_ERROR, {error}) }
}

// mutations
const mutations = {
	[types.SET_ERROR] (state, {error}) {
		state.error = error
	}
}

export default {
	state,
	getters,
	actions,
	mutations
}
