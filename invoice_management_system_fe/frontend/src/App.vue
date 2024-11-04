<template>
  <v-app>
    <BaseNavbar />
    <v-app-bar app>
      <v-toolbar-title>Invoice Management System</v-toolbar-title>
    </v-app-bar>
    <v-main>
      <router-view></router-view>
    </v-main>
  </v-app>
</template>

<script setup>
import BaseNavbar from './components/BaseNavbar.vue';
</script>
