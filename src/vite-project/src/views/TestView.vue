<script setup lang="ts">
const fns = {
    getMovies() {
        fetch('http://localhost:8080/movie?page=1&pageSize=10', {
            headers: {
                username: 'zzq'
            },
            credentials: 'include',
            mode: 'cors'
        }).then(res => res.json()).then(function (result) {
            console.log(result)
        })
    }
}
</script>

<template>
    <el-button v-for="(fn,fnName) in fns" @click="fn">{{ fnName }}</el-button>
</template>

<style scoped>

</style>