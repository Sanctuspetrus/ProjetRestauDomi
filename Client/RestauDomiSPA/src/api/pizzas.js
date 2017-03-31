const _listPizzas = [
	{
		id: 1,
		name: 'Chorizo',
		price: 11,
		ingredients: [ 1, 2, 3, 4, 5 ],
		dough: 1,
		autor: 'Pizza Yolo',
		favoris: []
	},
	{
		id: 2,
		name: 'Margarita',
		price: 10,
		ingredients: [1, 4],
		dough: 1,
		autor: 'Pizza Yolo'
	},
	{
		id: 3,
		name: 'Tartiflette',
		price: 12,
		ingredients: [ 6, 7, 8, 10 ],
		dough: 1,
		autor: 'Pizza Yolo'
	}
]
/**
* @return {Promise} liste des pizzas
*/
export default {
	getPizzas (resolve) {
		setTimeout(() => resolve(_listPizzas), 100)
	},
	savePizza(pizza, resolve, reject) {
		setTimeout(() => resolve(pizza), 100)
	},
	updatePizza(pizza, resolve, reject) {
		setTimeout(() => resolve(pizza), 100)
	},
	deletePizza(id, resolve, reject) {
		setTimeout(() => resolve(true), 100)
	}
}
