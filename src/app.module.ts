import { LogsModule } from './logs/Logs.module';
import { VeiculosModule } from './veiculos/veiculos.module';
import { EstabelecimentosModule } from './estabelecimentos/estabelecimentos.module';
import { Module } from '@nestjs/common';
import { AppController } from './app.controller';
import { AppService } from './app.service';
import { ConfigModule } from '@nestjs/config';
import { getEnvPath } from './common/envs/env.helper';

const envFilePath: string = getEnvPath(`${__dirname}/common/envs`);

@Module({
  imports: [
    EstabelecimentosModule,
    VeiculosModule,
    LogsModule,
    ConfigModule.forRoot({ envFilePath, isGlobal: true })],
  controllers: [AppController],
  providers: [AppService],
})


export class AppModule { }
