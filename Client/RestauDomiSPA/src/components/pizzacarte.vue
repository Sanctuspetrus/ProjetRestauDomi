<template>
	<div class="pizza">
		<div class="panel panel-default">
			<div class="panel-heading style-text">{{name}}
			</div>
			<div class="panel-body">
				Ingrédients:
				<ul>
					<li v-for="ing in listIngredients">{{ing.name}}</li>
				</ul>
				<p>Pâte: {{dough.name}}</p>
				<p>Auteur: {{autor}}</p>
				<span class="pull-right style-text">
					<span class="price">{{price}}€</span>
					<button @click="onClickPanelPizza()" class="btn btn-warning">
						<icon name="cart-plus" scale="1.5" ></icon>
					</button>
				</span>
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

.price {
	margin-left: 5px;
}

.style-text {
	font-weight: bold;
	font-size: 20px;
}

.bordererer {
	border: 2px solid orange;
	border-radius: 5px;
}

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
