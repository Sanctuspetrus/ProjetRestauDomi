import Vue from 'vue'
const DOMAIN = 'http://localhot:8000'

export default {
	/**
	* @return {Promise} réponse du serveur
	*/
	index (resource) {
		return Vue.http.get(DOMAIN + resource)
		.then((response) => Promise.resolve(response))
		.catch((error) => Promise.reject(error))
	},
	/**
	* @return {Promise} réponse du serveur
	*/
	show (resource, id) {
		return Vue.http.get(DOMAIN + resource + id)
		.then((response) => Promise.resolve(response))
		.catch((error) => Promise.reject(error))
	},
	/**
	* @return {Promise} réponse du serveur
	*/
	store (resource, data) {
		return Vue.http.post(DOMAIN + resource, data)
		.then((response) => Promise.resolve(response))
		.catch((error) => Promise.reject(error))
	},
	/**
	* @return {Promise} réponse du serveur
	*/
	update (resource, id, data) {
		return Vue.http.put(DOMAIN + resource + id, data)
		.then((response) => Promise.resolve(response))
		.catch((error) => Promise.reject(error))
	},
	/**
	* @return {Promise} réponse du serveur
	*/
	delete (resource, id) {
		return Vue.http.delete(DOMAIN + resource + id)
		.then((response) => Promise.resolve(response))
		.catch((error) => Promise.reject(error))
	}
}
