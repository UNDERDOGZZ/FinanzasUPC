import { Usuario } from "./usuario";

export class Contrato {
    id:number;
    usuarioId:Usuario;
    moneda :string;
    precioVenta: number;
    numeroAnnos: number;
    frecuenciaDePago:number;
    numeroDiasPorAnno:number;
    porcentajeTEA: number;
    porcentajeIGV: number;
    porcentajeImpuestoRenta: number;
    porcentajeRecompra: number;
    costesNotariales: number;
    costesRegistrales: number;
    tasacion: number;
    comisionEstudio: number;
    comisionActivacion: number;
    comisionPeriodica: number;
    porcentajeSeguroRiesgo: number;
    tasaDescuentoKs: number;
    tasaDescuentoWACC: number;
    plazogracia:string;
    numeroCuotasPG:number;
}
