<template>
	<div class="container">
		<h2>Commandes</h2>
		<table class="table">
			<thead>
				<tr>
					<th>Pizzas</th>
					<th>Quantité</th>
					<th>Prix</th>
					<th>Destination</th>
				</tr>
			</thead>
			<tbody>
				<tr v-for="commandes in allCommandes">
				</tr>
			</tbody>
		</table>
		<p>Total : {{totalPrice}}€</p>
	</div>
</template>

<script>
import { mapGetters, mapActions } from 'vuex'
import sidebar from 'components/Sidebar'
export default {
	name: 'commande',
	components: {
		sidebar
	},
	data () {
		return {
		}
	},
	computed: {
		...mapGetters([
			'allCommandes'
		])
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
