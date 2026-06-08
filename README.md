# Canchas API

API REST para la gestión de reservas de canchas de fútbol. Permite administrar canchas, turnos y reservas con un sistema de seña y pago.

## Tecnologías

- Java 21
- Spring Boot 3.5.14
- Spring Security + JWT
- PostgreSQL
- Docker
- Maven

## Funcionalidades

- Registro y autenticación con JWT
- Roles: ADMIN y USER
- CRUD de canchas y turnos (solo ADMIN)
- Reservas con sistema de seña (30% del total)
- Expiración automática de reservas sin seña en 6hs
- Pagos parciales (seña) y totales
- Validaciones en todos los endpoints

## Cómo levantar el proyecto

### Requisitos
- Java 21
- Maven
- Docker Desktop

### Pasos

1. Clonar el repositorio

```bash
git clone https://github.com/ngaleano13/canchas-api.git
cd canchas-api
```

2. Levantar la base de datos

```bash
docker compose up -d
```

3. Correr el proyecto

```bash
./mvnw spring-boot:run
```

## Endpoints

### Auth
| Método | Endpoint | Descripción | Auth |
|--------|----------|-------------|------|
| POST | /api/auth/register | Registrar usuario | No |
| POST | /api/auth/login | Login y obtener token | No |

### Canchas
| Método | Endpoint | Descripción | Auth |
|--------|----------|-------------|------|
| GET | /api/canchas | Listar canchas | USER |
| GET | /api/canchas/{id} | Obtener cancha | USER |
| POST | /api/canchas | Crear cancha | ADMIN |
| DELETE | /api/canchas/{id} | Eliminar cancha | ADMIN |

### Turnos
| Método | Endpoint | Descripción | Auth |
|--------|----------|-------------|------|
| GET | /api/turnos/{id} | Obtener turno | USER |
| GET | /api/turnos/canchas/{id} | Turnos por cancha | USER |
| POST | /api/turnos | Crear turno | ADMIN |
| DELETE | /api/turnos/{id} | Eliminar turno | ADMIN |

### Reservas
| Método | Endpoint | Descripción | Auth |
|--------|----------|-------------|------|
| POST | /api/reservas | Crear reserva | USER |
| GET | /api/reservas/{id} | Obtener reserva | USER |
| GET | /api/reservas/usuario/{id} | Reservas por usuario | USER |
| PUT | /api/reservas/{id}/cancelar | Cancelar reserva | USER |

### Pagos
| Método | Endpoint | Descripción | Auth |
|--------|----------|-------------|------|
| POST | /api/pagos | Registrar pago | USER |
| GET | /api/pagos/reserva/{id} | Pagos por reserva | USER |

## Autenticación

Todos los endpoints excepto /api/auth/** requieren un token JWT en el header:

```
Authorization: Bearer <token>
```