<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/styles/style.css">
    <link rel="stylesheet" href="/styles/normalize.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Akshar:wght@400;700&display=swap" rel="stylesheet">
    <title>JAVA_WEB</title>
</head>

<body>
    <header>
        <nav class="nav-bar">

            <a href="index.html">
                <h1>Lencho Pizza</h1>
            </a>

            <div class="enlaces">
                <a href="menu.html">Menu</a>
                <a href="ingresar.html">Ingresar</a>
            </div>
        </nav>
    </header>

    <main class="contenedor">
        <h2>Ingresar</h2>

        <div class="form">
            <form action="Validar" method="post" class="login">
                <div class="campos">
    
                    <svg viewBox="0 0 15 15" fill="none" xmlns="http://www.w3.org/2000/svg">
                        <path fill-rule="evenodd" clip-rule="evenodd"
                            d="M2.5 1C1.67157 1 1 1.67157 1 2.5V5H0V2.5C0 1.11929 1.11929 0 2.5 0H5V1H2.5ZM12.5 1H10V0H12.5C13.8807 0 15 1.11929 15 2.5V5H14V2.5C14 1.67157 13.3284 1 12.5 1ZM5 6H4V5H5V6ZM11 6H10V5H11V6ZM4.9 8.7C6.2 10.4333 8.8 10.4333 10.1 8.7L10.9 9.3C9.2 11.5667 5.8 11.5667 4.1 9.3L4.9 8.7ZM0 12.5V10H1V12.5C1 13.3284 1.67157 14 2.5 14H5V15H2.5C1.11929 15 0 13.8807 0 12.5ZM15 10V12.5C15 13.8807 13.8807 15 12.5 15H10V14H12.5C13.3284 14 14 13.3284 14 12.5V10H15Z"
                            fill="black" />
                    </svg>
    
                    <div class="campo">
                        <label for="usuario">Usuario</label>
                        <input type="text" id="usuario" name="usuario">
                    </div>
    
                    <div class="campo">
                        <label for="usuario">Contraseña</label>
                        <input type="password" id="pass" name="pass">
                    </div>
                    <a href="registro.html" class="registro">¿Eres Nuevo Usuario? Registrate</a>
    
                    <input type="submit" value="Ingresar" name="login" class="btn">
                </div>
    
            </form>
        </div>
    </main>

    <footer>
        <nav class="nav-footer">
            <div class="info">
                <div class="social">
                    <p>FB</p>
                    <p>Insta</p>
                    <p>Celular</p>
                </div>

            </div>
            <div class="info">
                <a href="index.html">
                    <h1>Lencho Pizza</h1>
                </a>
            </div>
        </nav>
    </footer>
</body>

</html>