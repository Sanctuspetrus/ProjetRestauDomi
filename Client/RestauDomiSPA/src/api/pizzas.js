
export default {
	/**
	* @return {Promise} liste des pizzas
	*/
	listPizzas () {
		return new Promise(function(resolve, reject) {
			return [
				{
					name: 'Margarita',
					price: 10,
					ingredients: [
						{
							name: 'sauce tomate',
							price: 0.3
						},
						{
							name: 'emmental',
							price: 0.3
						}
					],
					dough: {
						name: "blanche",
						price: 0.3
					},
					autor: 'Pizza Yolo'
				},
				{
					name: 'Tartiflette',
					price: 12,
					ingredients: [
						{
							name: 'Patates',
							price: 0.5
						},
						{
							name: 'Roblochon',
							price: 1.5
						},
						{
							name: 'oignons',
							price: 0.9
						},
						{
							name: 'crème fraiche',
							price: 1.1
						}
					],
					dough: {
						name: "blanche",
						price: 0.3
					},
					autor: 'Pizza Yolo'
				},
				{
					name: 'Chorizo',
					price: 11,
					ingredients: [
						{
							name: 'Sauce tomate',
							price: 0.3
						},
						{
							name: 'Sauce épicée',
							price: 0.6
						},
						{
							name: 'Chorizos',
							price: 1.3
						},
						{
							name: 'Emmental',
							price: 0.3
						},
						{
							name: 'Tomates',
							price: 1.1
						}
					],
					dough: {
						name: "Dorée",
						price: 0.3
					},
					autor: 'Pizza Yolo'
				}
			]
		});
	},

	/**
	* @return {Promise} liste des pizzas
	*/
	getPizzas () {
		return new Promise(function(resolve, reject) {
			return {
				name: 'Chorizo',
				price: 11,
				ingredients: [
					{
						name: 'Sauce tomate',
						price: 0.3
					},
					{
						name: 'Sauce épicée',
						price: 0.6
					},
					{
						name: 'Chorizos',
						price: 1.3
					},
					{
						name: 'Emmental',
						price: 0.3
					},
					{
						name: 'Tomates',
						price: 1.1
					}
				],
				dough: {
					name: "Dorée",
					price: 0.3
				},
				autor: 'Pizza Yolo',
				favoris: []
			}
		});
	}

}
