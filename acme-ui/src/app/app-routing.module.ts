import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { TarefaComponent } from './tarefa/tarefa.component';

const routes: Routes = [
  { path: 'tarefas', component: TarefaComponent },
  { path: '**', redirectTo: 'tarefas' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
