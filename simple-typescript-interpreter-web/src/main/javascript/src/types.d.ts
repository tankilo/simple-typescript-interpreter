
export type Maybe<T> = T | null;
export type Exact<T extends { [key: string]: unknown }> = { [K in keyof T]: T[K] };
export type MakeOptional<T, K extends keyof T> = Omit<T, K> & { [SubKey in K]?: Maybe<T[SubKey]> };
export type MakeMaybe<T, K extends keyof T> = Omit<T, K> & { [SubKey in K]: Maybe<T[SubKey]> };
/** All built-in and custom scalars, mapped to their actual values */
export type Scalars = {
  ID: string;
  String: string;
  Boolean: boolean;
  Int: number;
  Float: number;
  Primitive: any;
  Text: any;
  EncryptedText: any;
  TextArea: any;
  LongText: any;
  RichText: any;
  Integer: any;
  Long: any;
  Double: any;
  BigDecimal: any;
  Time: any;
  Date: any;
  DateTime: any;
  Email: any;
  PhoneNumber: any;
  Currency: any;
  Icon: any;
  Image: any;
  URL: any;
  Binary: any;
  Object: any;
};

export type Query = {
  __typename?: 'Query';
  GetBySql?: Maybe<Scalars['LongText']>;
  GetDcBannerByFilter?: Maybe<Array<Maybe<DcBanner>>>;
  AggregateDcBanner?: Maybe<DcBannerAggregate>;
  GetDcBanner?: Maybe<DcBanner>;
};


export type QueryGetBySqlArgs = {
  qson?: Maybe<Scalars['Text']>;
  params?: Maybe<Scalars['LongText']>;
  pageIndex?: Maybe<Scalars['Integer']>;
  pageSize?: Maybe<Scalars['Integer']>;
};


export type QueryGetDcBannerByFilterArgs = {
  _where?: Maybe<DcBannerBoolExp>;
  _limit?: Maybe<Scalars['Integer']>;
  _offset?: Maybe<Scalars['Integer']>;
  _order_by?: Maybe<Array<DcBannerOrderBy>>;
  _group_by?: Maybe<Array<DcBannerPrimitiveField>>;
};


export type QueryAggregateDcBannerArgs = {
  _where?: Maybe<DcBannerBoolExp>;
  _limit?: Maybe<Scalars['Integer']>;
  _offset?: Maybe<Scalars['Integer']>;
  _order_by?: Maybe<Array<DcBannerOrderBy>>;
  _group_by?: Maybe<Array<DcBannerPrimitiveField>>;
};


export type QueryGetDcBannerArgs = {
  id: Scalars['Long'];
};

export enum OrderByMode {
  Desc = 'desc',
  Asc = 'asc'
}

export type Condition = {
  _like?: Maybe<Scalars['String']>;
  _in?: Maybe<Array<Maybe<Scalars['Primitive']>>>;
  _nin?: Maybe<Array<Maybe<Scalars['Primitive']>>>;
  _btw?: Maybe<Array<Maybe<Scalars['Primitive']>>>;
  _nbtw?: Maybe<Array<Maybe<Scalars['Primitive']>>>;
  _eq?: Maybe<Scalars['Primitive']>;
  _neq?: Maybe<Scalars['Primitive']>;
  _gt?: Maybe<Scalars['Primitive']>;
  _gte?: Maybe<Scalars['Primitive']>;
  _lt?: Maybe<Scalars['Primitive']>;
  _lte?: Maybe<Scalars['Primitive']>;
  _isNull?: Maybe<Scalars['Boolean']>;
};

export type Mutation = {
  __typename?: 'Mutation';
  CreateDcBanner?: Maybe<Array<Maybe<DcBanner>>>;
  CreateOrUpdateDcBanner?: Maybe<Array<Maybe<DcBanner>>>;
  UpdateDcBanner?: Maybe<Scalars['Integer']>;
  DeleteDcBanner?: Maybe<Scalars['Integer']>;
};


export type MutationCreateDcBannerArgs = {
  toCreate?: Maybe<Array<DcBannerInput>>;
};


export type MutationCreateOrUpdateDcBannerArgs = {
  toCreate?: Maybe<Array<DcBannerInput>>;
};


export type MutationUpdateDcBannerArgs = {
  toUpdate?: Maybe<DcBannerInput>;
};


export type MutationDeleteDcBannerArgs = {
  id: Scalars['Long'];
};

export type DcBanner = {
  __typename?: 'DcBanner';
  id: Scalars['Long'];
  text: Scalars['Text'];
  seq: Scalars['Integer'];
  pic?: Maybe<Scalars['Text']>;
  obj_url?: Maybe<Scalars['Text']>;
};

export type DcBannerInput = {
  id?: Maybe<Scalars['Long']>;
  text?: Maybe<Scalars['Text']>;
  seq?: Maybe<Scalars['Integer']>;
  pic?: Maybe<Scalars['Text']>;
  obj_url?: Maybe<Scalars['Text']>;
};

export type DcBannerBoolExp = {
  _and?: Maybe<Array<Maybe<DcBannerBoolExp>>>;
  _or?: Maybe<Array<Maybe<DcBannerBoolExp>>>;
  id?: Maybe<Condition>;
  text?: Maybe<Condition>;
  seq?: Maybe<Condition>;
  pic?: Maybe<Condition>;
  obj_url?: Maybe<Condition>;
};

export type DcBannerOrderBy = {
  id?: Maybe<OrderByMode>;
  text?: Maybe<OrderByMode>;
  seq?: Maybe<OrderByMode>;
  pic?: Maybe<OrderByMode>;
  obj_url?: Maybe<OrderByMode>;
};

export enum DcBannerPrimitiveField {
  Id = 'id',
  Text = 'text',
  Seq = 'seq',
  Pic = 'pic',
  ObjUrl = 'obj_url'
}

export type DcBannerAggregate = {
  __typename?: 'DcBannerAggregate';
  count?: Maybe<Array<Maybe<Scalars['Integer']>>>;
  max?: Maybe<DcBannerCalculationResult>;
  min?: Maybe<DcBannerCalculationResult>;
  sum?: Maybe<DcBannerCalculationResult>;
  avg?: Maybe<DcBannerCalculationResult>;
};

export type DcBannerCalculationResult = {
  __typename?: 'DcBannerCalculationResult';
  id?: Maybe<Array<Maybe<Scalars['Primitive']>>>;
  text?: Maybe<Array<Maybe<Scalars['Primitive']>>>;
  seq?: Maybe<Array<Maybe<Scalars['Primitive']>>>;
  pic?: Maybe<Array<Maybe<Scalars['Primitive']>>>;
  obj_url?: Maybe<Array<Maybe<Scalars['Primitive']>>>;
};


