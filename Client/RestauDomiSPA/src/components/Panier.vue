<template>


  <div class="container">
    <h2>Contenu du panier</h2>
    <table class="table">
      <thead>
        <tr>
          <th>Pizza</th>
          <th>Prix</th>
          <th>Quantité</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td>Margarita</td>
          <td>15€</td>
          <td>2</td>
        </tr>
        <tr>
          <td>Reine</td>
          <td>10€</td>
          <td>5</td>
        </tr>
        <tr>
          <td>Tartiflette</td>
          <td>5€</td>
          <td>1</td>
        </tr>
      </tbody>
    </table>


  </template>

  <script>

  export default {
    name: 'panier',
    components: {
    },
    props: {
    },
    data() {
      return {
      }
    },
    watch: {
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
