<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f1f1f1;
        }
        .login-container {
            width: 300px;
            margin: 0 auto;
            padding: 20px;
            background-color: #ffffff;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.2);
        }
        .login-container h2 {
            text-align: center;
            margin-bottom: 20px;
        }
        .login-form input[type="text"],
        .login-form input[type="password"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 3px;
        }
        .login-form button[type="submit"] {
            width: 100%;
            padding: 10px;
            background-color: #4CAF50;
            color: #ffffff;
            border: none;
            border-radius: 3px;
            cursor: pointer;
        }
        .login-form button[type="submit"]:hover {
            background-color: #45a049;
        }
        .login-form .error-message {
            color: #ff0000;
            margin-top: 10px;
        }
    </style>
</head>
<body>
<div class="login-container">

    <h2>Login</h2>

    <form action="/login" method="post" class="login-form">

        <input type="text" name="username" placeholder="Username" required><br>

        <input type="password" name="password" placeholder="Password" required><br>

        <button type="submit">Log in</button>
        <div class="error-message">${errorMessage!}</div>


        <a href="/restore">Forgot password</a>

    </form>
</div>
</body>
</html>

