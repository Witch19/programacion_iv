/*export type RootStackParamList = {
  Home: undefined;
  Details: { id: string; title: string };
  Settings: undefined;
  Demo: undefined; 
};*/

/*export type RootStackParamList = {
  Home: undefined;
  Details: { id: string; title: string };
  Settings: undefined;
  LoginForm: undefined;
};*/

/*export type RootStackParamList = {
  Home: undefined;
  Details: { id: string; title: string };
  Settings: undefined;
  LoginForm: undefined;
  Products: undefined;
};*/

export type RootStackParamList = {
  Home: undefined;
  Products: undefined;
  Details: { id: string; title:  string; detalle: string; marca: string };
  Profile: { userId: string; name: string; apellido: string };
  Settings: undefined;
  LoginForm: undefined;
};
