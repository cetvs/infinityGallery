package com.example.myapplication.di

//@Module
//@InstallIn(SingletonComponent::class)
object AppModule {
    //data
//    @Provides
//    @Singleton
//    fun provideDatabase(app: Application): AppDatabase {
//        return Room.databaseBuilder(
//            app.applicationContext,
//            AppDatabase::class.java,
//            AppDatabase.DATABASE_NAME
//        ).fallbackToDestructiveMigration().build()
//    }
//    //data
//    @Provides
//    @Singleton
//    fun provideRetrofit(): Retrofit {
//        return Retrofit.Builder()
//            .baseUrl(Constants.BASE_URL)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//    }
//    //data
//    @Provides
//    @Singleton
//    fun provideSimpleApi(retrofit: Retrofit): SimpleApi {
//        return retrofit.create(SimpleApi::class.java)
//    }
//    //data
//    @Provides
//    @Singleton
//    fun provideRepositoryDatabase(db: AppDatabase, simpleApi: SimpleApi): MainRepository {
//        return MainRepositoryImpl(db.menuDao(), simpleApi)
//    }
//    //domain
//    @Provides
//    @Singleton
//    fun provideMenuUseCases(mainRepository: MainRepository): MainUseCases {
//        return MainUseCases(
//            getProfileInfo = GetProfileInfo(mainRepository),
//            getPictureInfo = GetPictureInfo(mainRepository),
//            postAuthLogout = PostAuthLogout(mainRepository),
//            getLocalProfileInfo = GetLocalProfileInfo(mainRepository),
//            getLocalPictureInfo = GetLocalPictureInfo(mainRepository),
//            insertProfileInfo = InsertProfileInfo(mainRepository),
//            insertPicturesInfo = InsertPicturesInfo(mainRepository),
//            deleteProfileInfo = DeleteProfileInfo(mainRepository),
//            deleteAllMenuItems = DeleteAllMenuItems(mainRepository),
//        )
//    }
}