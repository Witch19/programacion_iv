export type Product = {
  id: string;
  name: string;
  price: number;
  marca: string;
  detalle: string;
};

export const PRODUCTS: Product[] = [
  { id: "p1", name: "Mouse", price: 12 , marca: "Logitech", detalle: "Mouse inalámbrico con alta precisión"},
  { id: "p2", name: "Keyboard", price: 25, marca: "Razer", detalle: "Teclado mecánico RGB" },
  { id: "p3", name: "Monitor", price: 180, marca: "Samsung", detalle: "Monitor 24 pulgadas Full HD" },
  { id: "p4", name: "Laptop Stand", price: 30, marca: "SteelSeries", detalle: "Soporte ajustable para laptop" },
  { id: "p5", name: "Headset", price: 45, marca: "HyperX", detalle: "Auriculares con sonido envolvente" },
];