# NovaTec App - Kotlin Jetpack Compose

Proyecto de app mobile con pantalla de login convertida de Figma a Kotlin Jetpack Compose.

## 📱 Características

- ✅ Pantalla de login responsive
- ✅ Campos de entrada (Email y Contraseña)
- ✅ Botón Sign In
- ✅ Link "Olvidaste tu contraseña?"
- ✅ Diseño con colores NovaTec (Cyan y Púrpura)
- ✅ Fondo decorativo con círculos

## 🎨 Paleta de Colores

- **Primary Cyan**: `#00D4FF`
- **Secondary Púrpura**: `#B800FF`
- **Dark**: `#2C2C2C`
- **Light Gray**: `#B3B3B3`
- **Border**: `#D9D9D9`

## 📁 Estructura del Proyecto

```
app/
├── src/
│   └── main/
│       ├── java/com/novatec/app/
│       │   ├── ui/
│       │   │   └── screens/
│       │   │       └── LoginScreen.kt
│       │   └── MainActivity.kt
│       └── res/
│           ├── values/
│           │   └── strings.xml
│           └── drawable/
│               └── (imágenes del logo)
├── build.gradle.kts
└── README.md
```

## 🚀 Configuración

### 1. Clonar/Importar en Android Studio

```bash
# Si tienes solo estos archivos, crea un nuevo proyecto Android
# y copia estos archivos en los directorios correspondientes
```

### 2. Agregar el Logo

Descarga la imagen del logo desde Figma y colócala en:
```
res/drawable/novatec_logo.png
```

Luego, en `LoginScreen.kt`, descomenta y usa:
```kotlin
AsyncImage(
    model = R.drawable.novatec_logo,
    contentDescription = "NovaTec Logo",
    modifier = Modifier.size(212.dp),
    contentScale = ContentScale.Fit
)
```

### 3. Configurar la Fuente Inter

1. Descarga la fuente Inter de Google Fonts
2. Copia el archivo `.ttf` a `res/font/inter_regular.ttf`
3. La app ya la usa en `InterFont`

## 📦 Dependencias

- **Jetpack Compose**: UI toolkit declarativo
- **Material3**: Componentes Material Design
- **Coil**: Carga de imágenes
- **Navigation Compose**: Navegación en Compose

## 🎯 Pasos Siguientes

1. **Implementar Lógica de Login**
   ```kotlin
   var isLoading by remember { mutableStateOf(false) }
   
   SignInButton(
       onClick = {
           isLoading = true
           // Llamar API de login
       },
       isLoading = isLoading
   )
   ```

2. **Agregar Validaciones**
   ```kotlin
   val emailError = if (!isValidEmail(email)) "Email inválido" else ""
   val passwordError = if (password.length < 6) "Min. 6 caracteres" else ""
   ```

3. **Conectar con Backend**
   - Usar Retrofit para API calls
   - Implementar AuthViewModel
   - Manejar estados de error/éxito

4. **Agregar Más Pantallas**
   - Pantalla de Registro
   - Recuperación de Contraseña
   - Dashboard

## 📸 Pantallas Disponibles en Figma

- iPhone 17 - 1: Splash con logo grande
- iPhone 17 - 2: Pantalla de login
- iPhone 17 - 3: Pantalla de login con formulario

## 💡 Notas

- El diseño es **mobile-first** para app Android
- Se usa **Jetpack Compose** (UI moderna de Android)
- Los colores siguen el diseño de NovaTec
- La tipografía usa **Inter** como fuente principal

## 📝 Licencia

Proyecto privado NovaTec

---

Para más detalles, consulta la documentación de Jetpack Compose: https://developer.android.com/jetpack/compose
