<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Password Reset Token</title>

    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f1f1f1;
        }
        .resetting {
            width: 300px;
            margin: 0 auto;
            padding: 20px;
            background-color: #ffffff;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.2);
        }
        .resetting input[type="token"],
        .resetting input[type="password"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 3px;
        }
        .resetting button[type="submit"] {
            width: 100%;
            padding: 10px;
            background-color: #4CAF50;
            color: #ffffff;
            border: none;
            border-radius: 3px;
            cursor: pointer;
        }
        .resetting button[type="submit"]:hover {
            background-color: #45a049;
        }
        .resetting .error-message {
            color: #ff0000;
            margin-top: 10px;
        }
    </style>
</head>

<body>
<h2>Password Reset Token</h2>

<p>This is your password for resetting token: ${randomToken}</p>

<form action="/resetPass" method="post" class="resetting">

    <input type="text" name="email" placeholder="Enter email one more time" required><br>

    <input type="text" name="token" placeholder="Enter token" required><br>

    <input type="password" name="password" placeholder="Enter new password" required><br>

    <button type="submit">Log in</button>
    <div class="error-message">${errorMessage!}</div>

</form>

</body>
</html>