import { Contrato } from "./contrato";

export class Flujo {
    contratoId: Contrato;
    plazoGracia: string;
    saldoInicial: number;
    interes: number;
    cuota: number;
    amortizacion: number;
    seguroRiesgo: number;
    comision: number;
    recompra: number;
    saldoFinal: number;
    depreciacion: number;
    ahorroTributario: number;
    igv: number;
    flujoBruto: number;
    flujoIGV: number;
    flujoNeto:number;
    numeroFila:number;
}
