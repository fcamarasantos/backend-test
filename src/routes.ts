import express from "express";
import { EstablishmentController } from "./controllers/EstablishmentController";
import { VehicleController } from "./controllers/VehicleController";

export const routes = express.Router();

const establishmentController = new EstablishmentController();
const vehicleController = new VehicleController();

routes.post("/establishments", establishmentController.createEstablishment);

routes.post("/vehicles", vehicleController.createVehicle);
