# 28th BE SOPT ANDROID

:heavy_check_mark:**SECOND ASSIGNMENT**

<img width="1591" alt="스크린샷 2021-04-26 오후 2 06 43" src="https://user-images.githubusercontent.com/58849278/116031463-b2352800-a698-11eb-8aa5-df345d83890d.png">

:heavy_check_mark:**OPEN SOURCE LIBRARY**

| 라이브러리                                                   | 목적                                                    |
| ------------------------------------------------------------ | ------------------------------------------------------- |
| [Retrofit2](https://github.com/square/retrofit)              | Github Retrofit2 통신                                              |
| [Gson](https://github.com/google/gson)                       | 서버에서 받아온 Json 객체를 Gson으로 변환               |
| [OkHttp3](https://square.github.io/okhttp/)                   |  Util 기능 제작에 활용 |
| [Lottie](https://github.com/airbnb/lottie-android/)          | 로그인, 회원가입 페이지 Lottie Animation 사용 
| [Glide](https://github.com/bumptech/glide)                   | URL 형식의 이미지          |       
| [RxJava](https://github.com/ReactiveX/RxJava)                   | Observer Pattern 사용        |    
| [RxKotlin](https://github.com/ReactiveX/RxKotlin)                   | Observable Method 활용        |                  
| [LiveData](https://github.com/ravi8x/LiveData)                   | LifeCycleOwner 관찰자 등록        |    

## :seedling: **기본 과제**


:heavy_check_mark: **2주차 개념 정리**


:bulb: **FRAGMENT**는 UI를 개별적으로 분할할 수 있도록 하여 Activity UI에 **모듈성과 재사용성**을 높여준다는 사실 ! 앞으로 Activity보다 Fragment 를 더 활용해봐야겠다. 프래그먼트의 생명주기는 액티비티와 달라서 **(1) onCreateView()** 에서는 뷰와 관련된 초기화들이 이루어지고**(2) onViewCreated()** 에서는 **프래그먼트가 액티비티에 접근**할 수 있게 해준다!

:bulb: **LIST** 를 띄워주기 위해서는, Recyclerview를 사용한다. 나는 Recyclerview 공포증이 있었는데 ,, 나에겐 너무 어려웠던... 하지만 이번 세미나를 다시 들으면서 하나하나 다시 정리하고 복습하니까 이제 무섭지 않은 리사이클러뷰 :curly_loop: 다른 예제들도 보면서 더 연습해봐야겠다 !  Recyclerview 작업 순서는 다음과 같다. 

<img width="400" alt="스크린샷 2021-04-26 오후 2 44 51" src="https://user-images.githubusercontent.com/58849278/116034291-01ca2280-a69e-11eb-812b-ac06e00c8c69.png">

:bulb: **Adapter** 는 **데이터를 뷰로 변환**하는 다양한 상호작용 방법을 정의하는 장치, **Viewholder**는 **뷰의 구성요소를 홀드**해주는 역할! Recyclerview를 활용하는 작업이 앞으로도 많을텐데 이번 세미나에서 정확히 알고 넘어갈 수 있었던 기회였던 것 같아 좋았다 !!! :books: 

## :hatching_chick: 안린이 탈출하기 

1. 1주차 과제 HomeActivity에 Recyclerview 추가해주기 
2. 레포지토리 이름과 설명이 긴 경우, ellipSize 와 maxLine 을 이용해 ... 처리해주기 
3. more 버튼을 추가해서 Fragment를 가진 Activity 띄워주기 

:postbox: 저는 처음에 HomeActivity 하단에 리사이클러뷰를 넣어서 과제 예시 화면과 같이 구성을 했으나, 깃허브 레포를 레트로핏을 활용하여 해보고 싶어서 Github API 를 받아와서 사용자를 검색했을 때, 사용자의 레포 이름과 설명 언어를 받아오는 식으로 구현을 해봤습니다.  그래서 과제 예시 화면과 조금 다르게 HomeActivity 상단 툴바에 버튼을 추가하여 다음 화면처럼 구성을 해보았습니다. 

<img src="https://user-images.githubusercontent.com/58849278/116036476-ba459580-a6a1-11eb-8cf5-28a6e6c624bf.png" width = "300" height = "500"><img src="https://user-images.githubusercontent.com/58849278/116035863-af3e3580-a6a0-11eb-9daf-91912567df5f.png" width = "300" height = "500">


## :hatched_chick: 안청년 탈출하기 

1. GridLayoutManager 사용해보기 

:one: 홈화면에서 다음 화면으로 이동을 했을 때, LinearLayout 버튼과 GridLayout 버튼을 눌렀을 때 각각 다음 화면처럼 레이아웃이 바뀌는 것을 볼 수 있습니다. 
:two: 검색할 수 있는 기능을 추가하여 깃허브 사용자 아이디를 검색하면 해당 유저의 레포 정보들이 다음과 같이 뜨는 것을 볼 수 있습니다. 
:three: 아이템을 눌렀을 때, 해당 유저의 레포로 이동하는 기능도 추가하였습니다. 

<img src ="https://user-images.githubusercontent.com/58849278/116035956-d7c62f80-a6a0-11eb-9ecd-7149b274f743.png" width = "200" height = "400"><img src ="https://user-images.githubusercontent.com/58849278/116036869-48ba1700-a6a2-11eb-8104-2057cfd7637a.png" width = "200" height = "400"><img src ="https://user-images.githubusercontent.com/58849278/116037041-8028c380-a6a2-11eb-9869-04432163a58f.png" width = "200" height = "400">

2. 여러 뷰홀더를 만들어서 Recyclerview안에 2가지 뷰 보여주기 
레이아웃만 변경하는게 아니라 아이템 레이아웃을 2개 만들어줘서 뷰홀더안에 2가지 뷰를 보여주는 식으로 구성을 해봤습니다. 

3. RecyclerView Item 에 기능 추가하기 

:one: item 길게 눌러서 위치를 변경하기 
:two: item 옆으로 swipe해서 delete 하기 
:three: 버튼 추가해서 linear -> grid 로 바꿔보기 
:four: 버튼 눌렀을 때 효과 넣어주기 
:five: Item Decoration 

<img src = "https://user-images.githubusercontent.com/58849278/115998031-529b3600-a620-11eb-9667-e36795f7768b.gif" width = "300" height = "500" >


## :sunflower: 나도 안드 고수를 향해서 !!! 

이 부분은 코드에 한번 적용해보았습니다! 패키지 확인 

 1. 객체지향 한 걸음 더 -> BindingAdapter, UiState 

 2. notifyDataSetChanged -> diffUtil 사용 
 

  

		   class FollowingListAdapter(val listener: OnItemClickListener) : 				RecyclerView.Adapter<FollowingListAdapter.FollowingUserViewHolder>() {  
	      val diffCallback = object : 		DiffUtil.ItemCallback<RepositoryResponseModelItem>(){  
	      override fun areItemsTheSame(  
	      oldItem: RepositoryResponseModelItem,  
	      newItem: RepositoryResponseModelItem  
	      ): Boolean {  
	      return oldItem.hashCode() == newItem.hashCode()  
	    	 }  
	    	  override fun areContentsTheSame(  
	      oldItem: RepositoryResponseModelItem,  
	      newItem: RepositoryResponseModelItem  
	      ): Boolean {  
	      return oldItem == newItem  
	      }  
	     }  
	      interface OnItemClickListener{  
	      fun itemClickListener(view: View, position: Int)  
	     }  
	      val differ = AsyncListDiffer(this, diffCallback)  
      
	      fun submitList(list : List<RepositoryResponseModelItem>) = 		differ.submitList(list)
    
 ## :clapper: Record 

<img src = "https://user-images.githubusercontent.com/58849278/116039905-4bb70680-a6a6-11eb-86f5-ff6b87d137ff.gif" width = "200" height = "450" ><img src = "https://user-images.githubusercontent.com/58849278/116041453-2e833780-a6a8-11eb-92ed-4cebf0ac2d58.gif" width = "200" height = "450" ><img src = "https://user-images.githubusercontent.com/58849278/116041670-6f7b4c00-a6a8-11eb-8ea5-2607e3fed21d.gif" width = "200" height = "450" >


 
