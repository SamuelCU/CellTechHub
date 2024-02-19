-- Crear la base de datos
DROP DATABASE Tienda;
CREATE DATABASE Tienda;

USE Tienda;

-- Tabla para empleados/usuarios

CREATE TABLE empleados (
    id_empleado INT PRIMARY KEY,
    nombre VARCHAR(100),
    contraseña VARCHAR(100),
    tipo VARCHAR(20) 
);

-- Tabla para categorías de productos
CREATE TABLE categoria (
    id_categoria INT PRIMARY KEY,
    nombre VARCHAR(100)
);


-- Tabla para productos
CREATE TABLE producto (
    id_producto INT PRIMARY KEY,
    nombre VARCHAR(100),
    precio DECIMAL(10, 2),
    stock INT,
    id_categoria INT,
    FOREIGN KEY (id_categoria) REFERENCES categoria(id_categoria)
);



-- Tabla para ventas
CREATE TABLE venta (
    id_venta INT PRIMARY KEY,
    id_empleado INT,
    fecha DATETIME,
    total DECIMAL(10, 2),
    FOREIGN KEY (id_empleado) REFERENCES empleados(id_empleado)
);

-- Tabla para detalles de ventas
CREATE TABLE detalle_venta (
    id_detalle_venta INT PRIMARY KEY,
    id_venta INT,
    id_producto INT,
    cantidad INT,
    precio_unitario DECIMAL(10, 2),
    FOREIGN KEY (id_venta) REFERENCES venta(id_venta),
    FOREIGN KEY (id_producto) REFERENCES producto(id_producto)
);

-- Tabla para clientes
CREATE TABLE cliente (
    id_cliente INT PRIMARY KEY,
    nombre VARCHAR(100),
    email VARCHAR(100),
    telefono VARCHAR(20)
);

-- Tabla para relación entre ventas y clientes (para notas de venta)
CREATE TABLE cliente_venta (
    id_venta INT,
    id_cliente INT,
    PRIMARY KEY (id_venta, id_cliente),
    FOREIGN KEY (id_venta) REFERENCES venta(id_venta),
    FOREIGN KEY (id_cliente) REFERENCES cliente(id_cliente)
);
