<%-- 
    Document   : index
    Created on : Mar 9, 2014, 12:58:14 PM
    Author     : Andrea
--%>
<%@page import="com.Usuario"%>
<%
    Usuario usuario = new Usuario();//se usa un constructor vacio para evitar nullPointerException
    if (request.getSession().getAttribute("usuario") == null) {
        response.sendRedirect("index.jsp");
    } else {
        usuario = (Usuario) request.getSession().getAttribute("usuario");
    }

%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!-- Bootstrap -->

        <link href="css/bootstrap.min.css" rel="stylesheet">
        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
          <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>
    <body>



        <nav class="navbar navbar-inverse" role="navigation">
            <div class="container-fluid">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                        <span class="sr-only">Tipo de navegacion</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="index.jsp" style='color: #F7E136;'><strong>DogeMine</strong></a>
                </div>

                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">

                        <!-- 
                        <li><a href="#">Link</a></li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown <b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li><a href="#">Action</a></li>
                                <li><a href="#">Another action</a></li>
                                <li><a href="#">Something else here</a></li>
                                <li class="divider"></li>
                                <li><a href="#">Separated link</a></li>
                                <li class="divider"></li>
                                <li><a href="#">One more separated link</a></li>
                            </ul>
                        </li>
                        -->
                    </ul>

                    <%                         if (usuario.getNombre() != null) {
                            out.println("<a href=\"cerrarsesion.jsp\"><button type=\"submit\" class=\"btn btn-success btn-lg pull-right\">Logout</button></a>");
                        }
                    %>
                </div><!-- /.navbar-collapse -->
            </div><!-- /.container-fluid -->
        </nav>

        <div id="popover" style="z-index: 10; position: fixed; bottom: 290px; right: 70px; width: 300px; height: 150px; background-color: #F7E136;; border-radius: 50px; visibility: hidden; opacity: 0.8">
            <h2 id="poptext" style="text-align:center; margin-top: 20%">such popover</h2>
        </div>
        <div id="doge" style="width: 300px; height: 350px; position: fixed; bottom: -220px; right: 100px; z-index: 300;">

            <img src="doge.png" alt="doge" height="100%" width="100%"/>

        </div>


        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
        <!-- Include all compiled plugins (below), or include individual files as needed -->
        <script src="js/bootstrap.min.js"></script>
        <script type="text/javascript">
            $(document).ready(function() {
                //$('#dogem').popover('hide');
                $("#dogem").popover({
                    content: "Loading...",
                    placement: "bottom"
                });
            });
            $('#doge').mouseenter(function() {
                $('#doge').css("bottom", "-220px")
                        .css("transition", "all 0.4s ease") // you may also (-moz-*, -o-*, -ms-*) e.g
                        .css("bottom", "-100px").delay(10).queue(function() {
                    $('#doge').css("bottom", "-50px");
                    $('#doge').dequeue();
                });
            });
            $('#doge').mouseleave(function() {
                $('#doge').css("bottom", "-50px")
                        .css("transition", "all 0.4s ease") // you may also (-moz-*, -o-*, -ms-*) e.g
                        .css("bottom", "-100px").delay(10).queue(function() {
                    $('#doge').css("bottom", "-220px");
                    $('#doge').dequeue();
                });
                $('#popover').css('visibility', 'hidden');
            });
            $('#doge').click(function() {
                $('#poptext').text(getText());
                $('#popover').css('visibility', 'visible');
            });


// Para agregar nuevas frases nadamas hay que agregar más elementos a 
// este array!
            var frases = new Array();
            frases[0] = 'Such Workers';
            frases[2] = 'Wow';
            frases[5] = 'very design';
            frases[6] = 'so style';
            frases[7] = 'much mining';

            var cnt = -1;
            
            //cambie el random por un contador para evitar que las frases
            //se repitan muy a menudo, el que quiera lo puede cambiar
            function getText() {
                if (cnt === frases.length) {
                    cnt = -1;
                }
                //var ran = Math.floor((Math.random() * frases.length) + 0);
                cnt++;
                return frases[cnt];
            }
        </script>
    </body>
</html>
