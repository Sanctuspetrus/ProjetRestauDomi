<template>


  <div class="creation">

    <div class="panel panel-default">
      <div class="panel-heading" style="font-weight:bold; font-size:30px">Création de votre pizza</div>
      <div class="panel-body">
        <div class="row">
          <div class="col-sm-6">
            <div class="panel panel-default">
              <img width="50%" height="50%" src="~assets/pizzadessin.jpg">
            </div>
          </div>
          <div class="col-sm-6">
            <div class="panel panel-default">
              <form class="form-horizontal panel-droite">
                <div class="form-group nom-pizza">
                  <label for="input-pizza-name" class="col-sm-6 control-label">Nom de la pizza: </label>
                  <div class="col-sm-6">
                    <input type="text" name="" v-model="pizzaName" class="btn-block">
                  </div>
                </div>
                <div class="form-group">
                  <label for="select-pate" class="col-sm-6 control-label">Choisissez votre pâte: </label>
                  <div class="col-sm-6">
                    <v-select label="name" v-model="selectedPate" :options="allDoughs"></v-select>
                  </div>
                </div>
                <div class="form-group">
                  <label for="select-pate" class="col-sm-6 control-label">Choisissez vos ingrédients: </label>
                  <div class="col-sm-6">
                    <v-select multiple label="name" v-model="selectedIngredients" :options="allIngredients"></v-select>
                  </div>
                </div>
              </form>
            </div>
          </div>
          <label for="input-pizza-name" class="control-label pull-right" style="margin-right: 50px; font-size: 200%">Prix : {{totalPrice}}€ </label>
        </div>
      </div>

      <div class="pull-right" style="margin-right: 50px; margin-top: 25px">
        <button type="submit" @click="clicktoCreatePizza()" class="btn btn-warning btn-lg pull-right" >Valider</button>
      </div>
    </div>
  </div>

</template>

<script>
import { mapGetters, mapActions } from 'vuex'

export default {
  name: 'creationPizza',
  created () {
    this.$store.dispatch('getAllPizzas')
  },
  components: {
  },
  props: {
  },
  computed: {

    totalPrice() {
      var total = 0
      if (this.selectedPate != null) {
        total = this.selectedPate.price
      }
      if (this.selectedIngredients != null) {
        for (var i = 0; i < this.selectedIngredients.length; i++) {
          total += this.selectedIngredients[i].price
        }
      }
      return total
    },

    ...mapGetters([
      'allIngredients',
      'allDoughs',
      'error'
    ])
  },
  data() {
    return {
      selectedPate: null,
      selectedIngredients: null,
      pizzaName: '',
      pateName: 'choisissez votre pâte'
    }
  },
  watch: {
  },
  methods: {
    clicktoCreatePizza() {
      if (this.pizzaName === '' || this.selectedPate === null || this.selectedIngredients === null) {
        this.$toasted.error('Veuillez remplir tous les champs.', {duration: 1000})
      } else {
        this.setName(this.pizzaName)
        this.setPrice(this.totalPrice)
        this.setDough(this.selectedPate)
        for (var i = 0; i < this.selectedIngredients.length; i++) {
          console.log(this.selectedIngredients[i])
          this.addIngredient(this.selectedIngredients[i].id)
        }
        this.addPizza()
        if (this.error !== null && this.error.description === 'cette pizza existe déjà') {
          this.$toasted.error('Ce nom existe déjà.', {duration: 1000})
        } else {
          this.$toasted.success(this.pizzaName + ' ajoutée au panier.', {duration: 1000})
        }
      }
    },
    ...mapActions([
      'addPizza',
      'setName',
      'setPrice',
      'setDough',
      'addIngredient'
    ])
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

.nom-pizza {
  margin-top: 15px;
}

.panel-droite {
  margin-right: 15px;
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

.input-class {
  margin-left: 5px;
  margin-right: 5px;
}

a {
  color: #f9a400;
}
</style>
