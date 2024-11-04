<template>
    <form @submit.prevent="submit">
      <v-text-field
        v-model="name"
        label="Full name"
        :rules="rules"
      ></v-text-field>

      <v-text-field
        v-model="username"
        label="Username"
        :rules="rules"
      ></v-text-field>
  
      <v-text-field
        v-model="password"
        label="Password"
        :rules="rules"
      ></v-text-field>
  
      <v-select
        v-model="role"
        :items="items"
        label="Role"
        :rules="rules"
      ></v-select>
  
      <v-btn
        class="me-4"
        type="submit"
        v-on:click="signUp"
      >
        Sign up
      </v-btn>
  
      <v-btn v-on:click="clearData">
        Clear
      </v-btn>
    </form>
  </template>
  <script setup>
    import { ref } from 'vue'
    import {createUser} from '../api/axios.js'

    let name = ref('')
    let username = ref('')
    let password = ref('')
    let role = ref('')

    const rules = [
    value => {
            if (value) return true
            return 'Field can\'t be empty'
          },
    ]
  
    const items = ref([
      'Administrator',
      'Accountant',
      'Standard user',
    ])

    const signUp = () => {
      const user = {
        name: name.value,
        username: username.value,
        password: password.value,
        role: [role.value]
      }
      console.log(user)
      createUser(user)
    }

    const clearData = () => {
      name.value = ''
      username.value = ''
      password.value = ''
      role.value = ''
    }

  </script>