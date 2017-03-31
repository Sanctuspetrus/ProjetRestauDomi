<template>
	<div class="pizza">
		<div class="panel panel-default btn-default">
			<div class="panel-heading" style="font-weight:bold; font-size:18px">{{name}}</div>
			<div class="panel-body">
				<p>{{price}}€</p>
				Ingrédients:
				<ul>
					<li v-for="ing in listIngredients">{{ing.name}}</li>
				</ul>
				<p>Pâte: {{dough.name}}</p>
				<p>Auteur: {{autor}}</p>
			</div>
		</div>
	</div>
</template>

<script>

export default {
	name: 'pizzaCarte',
	props: {
		name: String,
		price: Number,
		ingredients: {
			type: Array,
			default: () => { return [] }
		},
		dough: {
			type: Object,
			default: () => { return { name: '', price: 0 } }
		},
		autor: String
	},
	computed: {
		listIngredients () {
			return this.ingredients
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
