const _listIngredients = {
	ingredients: [
		{
			id: 1,
			name: 'Sauce tomate',
			price: 0.3
		},
		{
			id: 2,
			name: 'Sauce épicée',
			price: 0.6
		},
		{
			id: 3,
			name: 'Chorizo',
			price: 1.3
		},
		{
			id: 4,
			name: 'Emmental',
			price: 0.3
		},
		{
			id: 5,
			name: 'Tomate',
			price: 1.1
		},
		{
			id: 6,
			name: 'Patate',
			price: 0.5
		},
		{
			id: 7,
			name: 'Roblochon',
			price: 1.5
		},
		{
			id: 8,
			name: 'Oignon',
			price: 0.9
		},
		{
			id: 9,
			name: 'Jambon',
			price: 0.9
		},
		{
			id: 10,
			name: 'Crème fraiche',
			price: 1.1
		}
	],
	doughs: [
		{
			id: 1,
			name: 'Blanche',
			price: 0.3
		},
		{
			id: 2,
			name: 'Dorée',
			price: 0.3
		}
	]
}

/**
* @return {Promise} liste des pizzas
*/
export default {
	getIngredients (resolve) {
		setTimeout(() => resolve(_listIngredients), 100)
	}
}
