import { MilitaryCompany } from "../../MilCompany/model/militaryCompany";
export interface SoldierDetails {
  id: string;
  codename: string;
  specialty: string
  skillRank: number;
  militaryCompany: string;
}
