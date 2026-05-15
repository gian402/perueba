# 📱 GUÍA DE INSTALACIÓN - NovaTec App Kotlin

## ✅ PASO 1: COPIAR LAS IMÁGENES

1. Ve a la carpeta: `app/src/main/res/drawable/`
2. Copia las imágenes descargadas con estos nombres exactos:

```
file.png          →  novatec_logo.png
file 2.png        →  elipse_1.png
file 3.png        →  elipse_2.png
```

### 📂 Estructura Final

```
app/src/main/res/drawable/
├── novatec_logo.png
├── elipse_1.png
└── elipse_2.png
```

---

## ✅ PASO 2: CREAR PROYECTO EN ANDROID STUDIO

### 2.1 Crear nuevo proyecto
1. **File** → **New** → **New Android Project**
2. **Phone and Tablet** → **Empty Activity**
3. **Next** y configura:
   - Name: `NovaTec App`
   - Package name: `com.novatec.app`
   - Language: **Kotlin**
   - API Level: **24** (mínimo)

### 2.2 Reemplazar archivos
4. Abre el proyecto creado
5. Copia estos archivos de este proyecto a los correspondientes en Android Studio:

**De este proyecto → A Android Studio:**

```
app/build.gradle.kts          →  app/build.gradle.kts
settings.gradle.kts           →  settings.gradle.kts
build.gradle.kts              →  build.gradle.kts

app/src/main/AndroidManifest.xml → app/src/main/AndroidManifest.xml

app/src/main/kotlin/          →  app/src/main/kotlin/
app/src/main/res/values/      →  app/src/main/res/values/
app/src/main/res/drawable/    →  app/src/main/res/drawable/ (CON LAS IMÁGENES)
```

---

## ✅ PASO 3: SINCRONIZAR GRADLE

1. En Android Studio, aparecerá un botón **"Sync Now"**
2. Haz clic en él y espera a que termine
3. Si hay errores, revisa que:
   - Java 11+ esté instalado
   - Android SDK esté actualizado
   - Las imágenes estén en `drawable/`

---

## ✅ PASO 4: COMPILAR Y EJECUTAR

### Opción A: Emulador Android
1. **Tools** → **AVD Manager** → **Create Virtual Device**
2. Selecciona un dispositivo (ej: Pixel 4)
3. Descarga una imagen de sistema (API 34 recomendado)
4. Haz clic en **Run** (ícono play verde) en Android Studio

### Opción B: Dispositivo Físico
1. Conecta tu teléfono Android por USB
2. Activa "Debugging por USB" en el teléfono
3. Haz clic en **Run** en Android Studio

---

## 📋 VERIFICACIÓN DE ARCHIVOS

Asegúrate que existan estos archivos:

```
✅ app/src/main/kotlin/com/novatec/app/
   ├── MainActivity.kt
   ├── DrawableRes.kt
   └── ui/
       ├── screens/LoginScreen.kt
       └── theme/
           ├── Theme.kt
           ├── Color.kt
           └── Type.kt

✅ app/src/main/res/
   ├── drawable/
   │   ├── novatec_logo.png
   │   ├── elipse_1.png
   │   └── elipse_2.png
   └── values/
       ├── colors.xml
       ├── strings.xml
       └── themes.xml

✅ app/src/main/AndroidManifest.xml

✅ app/build.gradle.kts
✅ build.gradle.kts
✅ settings.gradle.kts
```

---

## 🎨 COLORES UTILIZADOS

```
Primary Cyan:    #00D4FF
Primary Purple:  #B800FF
Dark:            #2C2C2C
Light Gray:      #B3B3B3
Border:          #D9D9D9
White:           #FFFFFF
Text Light:      #F5F5F5
```

---

## 🚀 PANTALLA DE LOGIN

La pantalla incluye:
- ✅ Logo NovaTec centrado
- ✅ Campo Email (con validación de teclado)
- ✅ Campo Contraseña (caracteres ocultos)
- ✅ Botón "Sign In" (negro #2C2C2C)
- ✅ Link "Olvidaste tu contraseña?"
- ✅ Fondo blanco con detalles decorativos
- ✅ Material Design 3

---

## 🔧 PRÓXIMOS PASOS

### Implementar Login Real
En `LoginScreen.kt`, en la función `SignInButton()`:

```kotlin
SignInButton(
    onClick = {
        // TODO: Hacer llamada a API
        // viewModel.login(email, password)
    }
)
```

### Agregar Validaciones
```kotlin
val isEmailValid = email.contains("@")
val isPasswordValid = password.length >= 6
```

### Conectar Backend
1. Agregar Retrofit para API calls
2. Crear ViewModel
3. Implementar manejo de estados

---

## ❓ ERRORES COMUNES

### Error: "Unresolved reference R"
**Solución:** Sincroniza Gradle (`Ctrl + Shift + S`)

### Error: "Failed to find drawable"
**Solución:** Verifica que las imágenes estén en `app/src/main/res/drawable/`

### Error: "Kotlin compiler error"
**Solución:** Asegúrate que Java 11+ esté configurado en Project Structure

---

## 📞 SOPORTE

Si tienes problemas:
1. Verifica que todas las carpetas y archivos existan
2. Sincroniza Gradle nuevamente
3. Limpia la compilación: **Build** → **Clean Build Folder**
4. Reconstruye: **Build** → **Rebuild Project**

---

**¡Listo! Tu app Android debería compilar y ejecutarse sin problemas! 🎉**
