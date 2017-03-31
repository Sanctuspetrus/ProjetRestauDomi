<template>
	<div class="container">
		<h2>Commandes</h2>
		<table class="table">
			<thead>
				<tr>
					<th>Pizzas</th>
					<th>Prix</th>
					<th>Destination</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<tr v-for="commande in allCommandes">
					<td>
						<ul>
							<li v-for="item in commande.contenu">
								{{item.pizza.name}}({{item.amount}})
							</li>
						</ul>
					</td>
					<td>
						{{commande.price}} €
					</td>
					<td>
						{{commande.destination}}
					</td>
					<td>
						<button type="button" class="btn btn-default btn-xs"  @click="deleteCommande(commande)">
							<icon name="times-circle"></icon>
						</button>
					</td>
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
	methods: {
		deleteCommande (commande) {
			this.annulerCommande(commande.id)
			this.$toasted.error('Commande annulée', {duration: 1000})
		},
		...mapActions([
			'annulerCommande'
		])
	},
	computed: {
		totalPrice() {
			var total = 0
			for (var i = 0; i < this.allCommandes.length; i++) {
				total += this.allCommandes[i].price
			}
			return total
		},
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
