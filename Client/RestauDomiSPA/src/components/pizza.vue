<template>
	<div class="pizza">
		<h1>{{pizza.name}}</h1>
		<p>{{pizza.price}}€</p>
		Ingrédients:
		<ul>
			<li v-for="ing in pizza.ingredients">{{ing.name}}</li>
		</ul>
		<p>Pâte: {{pizza.dough}}</p>
		<p>Auteur: {{pizza.autor}}</p>
	</div>
</template>

<script>
import sidebar from 'components/Sidebar'
import apiPizzas from 'src/api/pizzas'

export default {
	name: 'pizza',
	props: {
		pizza: {
			type: Object,
			default: {
				name: 'default',
				price: 0,
				ingredients: [
					{
						name: 'default',
						price: 0
					}
				],
				dough: {
					name: 'default',
					price: 0
				},
				autor: 'default'
			}
		}
	}
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
	h1, h2 {
		font-weight: normal;
	}

	ul {
		list-style-type: none;
		padding: 0;
	}

	li {
		display: inline-block;
		margin: 0 10px;
	}

	a {
		color: #f9a400;
	}
</style>
