<template>
	<div class="compte">

		<connexion v-model="connected"></connexion>

		<!-- <inscription v-model="inscripted"></inscription> -->

	</div>
</template>

<script>
import sidebar from 'components/Sidebar'
import connexion from 'components/Connexion'
import inscription from 'components/Inscription'
export default {
	name: 'compte',
	components: {
		sidebar,
		connexion,
		inscription
	},
	data() {
		return {
			connected: {
				pseudo: '',
				password: '',
				connected: false
			}
		}
	},

	methods: {

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
