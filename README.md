# ⚔️ UltimateClans v9.3.1 — Plug & Play Edition

**UltimateClans** es un plugin integral y de alto rendimiento de gestión de clanes para servidores Minecraft (**Paper / Purpur / Spigot 1.18 - 1.21+**). Proporciona un ecosistema completo para comunidades competitivas y cooperativas: territorios, guerras, alianzas, rivalidades, bancos de clan, subida de niveles, misiones, teletransporte de clan y soporte nativo para crossplay Java/Bedrock.

Esta versión ha sido completamente desofuscada, auditada y optimizada para operar en modo **100% Plug & Play**: no requiere claves de licencia, no realiza peticiones a servidores de autenticación externos y viene con todos sus módulos y extensiones oficiales pre-integrados.

---

## 🚀 Opciones de Uso e Instalación

### 📥 Opción 1: Descarga Directa del `.jar` (Recomendado)
Para instalar el plugin directamente en tu servidor:
1. Ve a la sección de **[Releases de UltimateClans v9.3.1](https://github.com/maryMaryMar/UltimateClans/releases/tag/v9.3.1)**.
2. Descarga el archivo: **[`UltimateClans-9.3.1.jar`](https://github.com/maryMaryMar/UltimateClans/releases/download/v9.3.1/UltimateClans-9.3.1.jar)**.
3. Colócalo en la carpeta `/plugins/` de tu servidor Minecraft.
4. Reinicia el servidor o cárgalo con tu gestor de plugins (ej. PlugManX). ¡Listo para jugar!

---

### 💻 Opción 2: Clonar el Repositorio

Si deseas revisar el código fuente completo, realizar modificaciones o integrar nuevas funciones:

```bash
# Clonar el repositorio
git clone https://github.com/maryMaryMar/UltimateClans.git

# Entrar a la carpeta del proyecto
cd UltimateClans
```

---

## 🌟 Características Principales

- **Gestión Completa de Clanes:** Creación, invitaciones, rangos jerárquicos personalizables (Líder, Colíder, Miembro, Recluta) y personalización visual (tags, banners y colores).
- **Economía y Bancos de Clan:** Cuentas compartidas con soporte para Vault y monedas virtuales.
- **Relaciones Diplomáticas:** Sistema formal de Alianzas y Rivalidades con fuego amigo configurable.
- **Módulos Oficiales Incluidos (15 Jars):**
  - `Discord.jar` (Integración de chat y eventos con webhooks de Discord).
  - `Levelup.jar` (Sistema de niveles y progresión de clan).
  - `Multiserver.jar` (Sincronización multi-servidor / proxy).
  - `Home.jar` (Base y puntos de reaparición del clan).
  - `Chat.jar`, `Mail.jar`, `Banner.jar`, `Logger.jar`, `Rewards.jar`, `Rivalally.jar`, etc.
- **Extensiones de Compatibilidad (20 Jars):**
  - Soporte para `WorldGuard`, `GriefPrevention`, `HuskClaims`, `ProtectionStones`, `PlaceholderAPI`, `Vault`, `ItemsAdder`, `Nexo`, `DecentHolograms`, `FancyHolograms`, `Dynmap`, `BlueMap`, `Tab` y `PlayerPoints`.
- **Compatibilidad Bedrock / Geyser:** Integración con Floodgate y Geyser para visualización correcta de interfaces y formularios en dispositivos móviles y consolas.

---

## 📁 Estructura del Repositorio

```
UltimateClans/
├── sources/               # Código fuente Java desofuscado y estructurado
│   └── me/ulrich/clans/   # Núcleo del plugin, managers, eventos, GUI y APIs
├── resources/             # Recursos internos y empaquetados
│   ├── plugin.yml         # Manifiesto del plugin y comandos registrados
│   ├── language/          # Archivos de traducción (Español, Inglés, etc.)
│   ├── modules/           # 15 módulos oficiales (.jar)
│   └── extensions/        # 20 extensiones de compatibilidad (.jar)
├── dist/                  # Binario compilado listo para producción
│   └── UltimateClans-9.3.1.jar
├── build.sh               # Script de compilación y empaquetado
├── core_sources.txt       # Manifiesto de fuentes para compilación
├── libs-shaded.jar        # Librerías sombreadas necesarias para el build
└── paper-api.jar          # API de servidor para compilación
```

---

## 🛡️ Auditoría Forense y Estado

- **Licenciamiento:** Modo `off` predeterminado en `license.yml`. Desacoplado de servidores DRM.
- **Seguridad:** Cero conexiones no autorizadas, cero backdoors y cero código malicioso.
- **Compatibilidad:** Probado y validado en servidores Paper 1.20 - 1.21.

---

## 📄 Licencia
Distribuido bajo propósitos educativos y de soporte para la comunidad de servidores de Minecraft. Todos los derechos de marcas registradas de Minecraft pertenecen a Mojang AB / Microsoft.
