<template>
	<div class="pizza">
		<div class="panel panel-default btn-default" @click="onClickPanelPizza">
			<div class="panel-heading" style="font-weight:bold; font-size:18px">{{name}}
			<span class="pull-right"><icon name="cart-plus" scale="1.2"></icon></span></div>
			<div class="panel-body">
				Ingrédients:
				<ul>
					<li v-for="ing in listIngredients">{{ing.name}}</li>
				</ul>
				<p>Pâte: {{dough.name}}</p>
				<p>Auteur: {{autor}}</p>
				<p style="font-weight: bold; font-size: 15px">{{price}}€</p>
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
	methods: {
		onClickPanelPizza() {
			this.$emit('addToCart')
		}
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
