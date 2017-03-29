<template>
  <div class="connected">


    <div class="jumbotron text-center">
      <h1>Connexion</h1>
    </div>

    <div class="container">
      <form>
        <div class="form-group">
          <label for="pseudo">Identifiant:</label>
          <input type="pseudo" v-model="value.pseudo" class="form-control" id="email" placeholder="Identifiant">
        </div>
        <div class="form-group">
          <label for="pwd">Mot de passe:</label>
          <input type="password" v-model="value.password" class="form-control" id="pwd" placeholder="Mot de passe">
        </div>
        <button type="submit" @click="connexion" class="btn btn-warning">Connexion</button>
      </form>
      <p>{{message}}</p>
    </div>
    <div class="col-sm-10"></div>
    <div class="col-sm-4">
      <p>Pas de compte ? inscrivez-vous <router-link :to="{name: 'inscription'}">ici</router-link></p>
    </div>

  </div>
</template>

<script>

export default {
  name: 'connexion',
  components: {
  },

  props: {
    value: {
      type: Object,
      default: function () {
        return {
          pseudo: '',
          password: '',
          connected: false
        }
      }
    }
  },

  data() {
    return {
      message: ''
    }
  },

  watch: {
    value (newval) {
      this.$emit('input', newval)
    }

  },

  methods: {

    connexion() {
      if (this.value.pseudo === 'moi' && this.value.password === 'meme') {
        this.message = 'SUCCES !'
        this.value.connected = true
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
