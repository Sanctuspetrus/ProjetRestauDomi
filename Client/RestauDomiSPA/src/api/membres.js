const _listMembres = [
	{
		id: 1,
		login: 'jeanpeuplu',
		password: '1234',
		firstname: 'Jean',
		lastname: 'Peuplu',
		pizzas: [],
		favoris: []
	},
	{
		id: 2,
		login: 'guerre',
		password: '1234',
		firstname: 'Jhon',
		lastname: 'Rambo',
		pizzas: [],
		favoris: []
	},
	{
		id: 3,
		login: 'Nick',
		password: '1234',
		firstname: 'Phoenix',
		lastname: 'Wright',
		pizzas: [],
		favoris: []
	}
]
/**
* @return {Promise} liste des pizzas
*/
export default {
	getMembres (resolve) {
		setTimeout(() => resolve(_listMembres), 100)
	},
	saveMembre(membre, resolve, reject) {
		setTimeout(() => resolve(membre), 100)
	},
	updateMembre(membre, resolve, reject) {
		setTimeout(() => resolve(membre), 100)
	},
	deleteMembre(id, resolve, reject) {
		setTimeout(() => resolve(true), 100)
	}
}
