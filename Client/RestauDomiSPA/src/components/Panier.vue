<template>


  <div class="container">
    <h2>Contenu du panier</h2>
    <table class="table">
      <thead>
        <tr>
          <th>Pizza</th>
          <th>Quantité</th>
          <th>Prix</th>
        </tr>
      </thead>
      <tbody>

        <tr v-for="pizza in listPizzasPanier">
          <td>{{pizza.name}}</td>
          <td>moult</td>
          <td>{{pizza.price}}€</td>
        </tr>
      </tbody>
    </table>
    <p>Total : {{totalPrice}}€</p>
    <button type="submit" @click="paiement" class="btn btn-warning">Valider le payement</button>

  </template>

  <script>

  export default {
    name: 'panier',
    components: {
    },
    props: {
    },
    computed: {
      totalPrice() {
        var total = 0
        for (var i = 0; i < this.listPizzasPanier.length; i++) {
          total = total + this.listPizzasPanier[i].price
        }
        return total
      }
    },
    data() {
      return {
        listPizzasPanier: [
          {name: 'Margarita', price: 15},
          {name: 'Margarita', price: 15},
          {name: 'Reine', price: 5},
          {name: 'Reine', price: 5},
          {name: 'Reine', price: 5},
          {name: 'Reine', price: 5},
          {name: 'Reine', price: 5},
          {name: 'Reine', price: 5},
          {name: 'Reine', price: 5},
          {name: 'Tartiflette', price: 5}
        ]
      }
    },
    watch: {
    },
    methods: {
      paiement() {
        alert('Payé !')
      },
      quantity(nom) {
        var qty = 0
        for (var p in this.listPizzasPanier) {
          if (nom === p.name) qty++
        }
        return qty
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
