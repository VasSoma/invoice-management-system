<template>
    <v-sheet class="mx-auto" width="300">
      <v-form @submit.prevent="handleLogin">
        <v-text-field
          v-model="username"
          :rules="rules"
          label="Username"
        ></v-text-field>
        <v-text-field
          v-model="password"
          :rules="rules"
          label="Password"
          type="password"
        ></v-text-field>
        <v-btn class="mt-2" type="submit" block>Log in</v-btn>
      </v-form>
    </v-sheet>
  </template>

  <script setup>
    import {ref} from 'vue'
    import {loginUser} from '../api/axios.js'

    const username = ref('')
    const password = ref('')

    const rules = [
        value => {
            if (value) return true
            return 'Field can\'t be empty'
        },
    ]

    const handleLogin = async () => {
  const credentials = {
    username: username.value,
    password: password.value,
  };

  try {
    const response = await loginUser(credentials);
    console.log('Login successful:', response.data);
  } catch (error) {
    console.error('Login failed:', error);
  }
};
  </script>
