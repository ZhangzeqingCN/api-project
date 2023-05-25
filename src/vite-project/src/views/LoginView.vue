<script setup lang="ts">
function login() {

}
</script>
<template>
<div class="container">
<div class="login-box">
    <h1>Login</h1>
    <form th:action="@{/auth/login}" method="post">
        <div class="form-group">
            <label for="username">Username:</label>
            <input type="text" id="username" name="username"/>
        </div>
        <div class="form-group">
            <label for="password">Password:</label>
            <input type="password" id="password" name="password"/>
        </div>
        <button type="submit">Login</button>
        <a href="/test/register">Go to register</a>
    </form>
</div>
</div>
</template>

<style scoped>
.container {
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
    background-color: #f5f5f5;
}

.login-box {
    width: 400px;
    background-color: #fff;
    border-radius: 5px;
    padding: 30px;
    box-shadow: 0 0 20px rgba(0,0,0,0.2);
}

h1 {
    text-align: center;
    margin-bottom: 20px;
}

.form-group {
    margin-bottom: 20px;
}

label {
    display: block;
    margin-bottom: 5px;
}

input {
    width: 100%;
    padding: 10px;
    border: 1px solid #ccc;
    border-radius: 5px;
    font-size: 16px;
    outline: none;
}

button {
    display: block;
    width: 100%;
    padding: 10px;
    background-color: #007bff;
    color: #fff;
    border: none;
    border-radius: 5px;
    font-size: 16px;
    cursor: pointer;
}
</style>