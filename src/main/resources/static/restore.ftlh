<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Восстановление пароля</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
        }

        h2 {
            color: #333;
            text-align: center;
        }

        form {
            max-width: 400px;
            margin: 0 auto;
            padding: 20px;
            background-color: #fff;
            border: 1px solid #ccc;
            border-radius: 5px;
            margin-top: 100px;
        }

        label {
            display: block;
            margin-bottom: 10px;
            font-weight: bold;
        }

        input[type="email"] {
            width: 100%;
            padding: 8px;
            font-size: 14px;
            border-radius: 3px;
            border: 1px solid #ccc;
        }

        button[type="submit"] {
            display: block;
            margin-top: 10px;
            padding: 8px 12px;
            font-size: 14px;
            font-weight: bold;
            text-decoration: none;
            color: #fff;
            background-color: #007bff;
            border-radius: 3px;
            border: none;
            cursor: pointer;
        }

        button[type="submit"]:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
<h2>Восстановление пароля</h2>

<form action="/restore" method="post">
    <label for="email">Email:</label>
    <input type="email" id="email" name="email" required><br>

    <button type="submit">Восстановить пароль</button>
</form>
</body>
</html>