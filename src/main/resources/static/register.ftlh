<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">

    <title>Register Page</title>
</head>
<body>
<form action="/register" method="post">



<!--    <#if _csrf??>-->
<!--    <input type="hidden" name="${(_csrf.parameterName)!'csrf-param-name'}" value="${(_csrf.token)!'csrf-token'}" />-->
<!--</#if>-->


    <div class="form-group">
        <label for="exampleInputName">Name</label>
        <input type="text" class="form-control" id="exampleInputName" placeholder="Enter name" name="name">
    </div>

    <div class="form-group">
        <label for="exampleInputAccountName">Account Name</label>
        <input type="text" class="form-control" id="exampleInputAccountName" placeholder="Enter account name" name="accountName">
    </div>

    <div class="form-group">
        <label for="exampleInputEmail1">Email address</label>
        <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email" name="email">
    </div>

    <div class="form-group">
        <label for="exampleInputPassword1">Password</label>
        <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password" name="password">
    </div>

    <button type="submit" class="btn btn-primary">Submit</button>
</form>
</body>
</html>