
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Join Us</title>
        <link href="https://fonts.googleapis.com/css?family=ZCOOL+XiaoWei" rel="stylesheet">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    </head>
    <body class = "body">
      <div class="main_container">
            <div class="box">
            
            <nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Cruise Ship Activity Co-ordination System</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="homepage.html">Home</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="#"><span class="glyphicon glyphicon-user"></span><%= user.getFirstname() %></a></li>
      <li><a href="LogoutServlet"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
    </ul>
  </div>
</nav>
<div class="logo">
      <h1 class = "text-warning"><b>Cruise Ship Activity Co-ordination System</b></h1>
</div>
    
    <br>
  <h2 class="text-center" id="title">View Event Summary</h2>
        <div class="text-center">
<br><br><br>
<form id="hello" action="/action_page.php">
  <label for="Date">Date:</label>

<input type="date" value="<?php echo $today; ?>" class="form-control" id="date" name="date">
<br><br><br><br><br>

    <label for="Time">Time:</label>

  <input type="time" ><br><br><br><br><br>

   <button type="submit" class="btn btn-primary">Submit</button>
<br><br>
</form>
</div>
</body>
</html>