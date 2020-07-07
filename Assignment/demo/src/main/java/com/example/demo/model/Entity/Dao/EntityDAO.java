package com.example.demo.model.Entity.Dao;

import com.example.demo.model.Entity.*;
import com.example.demo.repository.*;
import com.example.demo.restDto.*;
import com.example.demo.service.transformers.*;
import com.example.demo.validation.BookingValidation;
import com.example.demo.validation.ContractValidation;
import com.example.demo.validation.RoomValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class EntityDAO {

    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private BookingTransformation bookingTransformation;
    @Autowired
    private BookingValidation bookingValidation;
    @Autowired
    private ContractValidation contractValidation;
    @Autowired
    private ContractRepository contractRepository;
    @Autowired
    private ContractTransformation contractTransformation;
    @Autowired
    private GuestRepository guestRepository;
    @Autowired
    private GuestTransformation guestTransformation;
    @Autowired
    private HotelRepository hotelRepository;
    @Autowired
    private HotelTransformation hotelTransformation;
    @Autowired
    private RoomValidation roomValidation;
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private RoomTransformation roomTransformation;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserTransformation userTransformation;

    /**
     * get All the not booking list
     *
     * @param checkInDate
     * @param checkOutDate
     * @return
     */
    public List<BookingDTO> getAllNotBookingList(Date checkInDate, Date checkOutDate) {

        List<BookingEntity> notBookingEntityList = new ArrayList<>();
        bookingRepository.findAllByCheckInDateLessThanAndCheckOutDateLessThan(checkInDate, checkInDate).forEach(notBookingEntityList::add);
        bookingRepository.findAllByCheckInDateGreaterThanAndCheckOutDateGreaterThan(checkOutDate, checkOutDate).forEach(notBookingEntityList::add);
        if (notBookingEntityList.isEmpty()) {
//            throw new NoBookingFoundException("Booking List is empty");
            throw new RuntimeException("Booking List is empty");
        }

        return bookingTransformation.getAllBookingDTOs(notBookingEntityList);
    }

    /**
     * get all the bookings
     *
     * @return
     */
    public List<BookingDTO> getAllBookings() {

        List<BookingEntity> allBookingEntities = new ArrayList<>();

        bookingRepository.findAll().forEach(allBookingEntities::add);
        if (allBookingEntities.isEmpty()) {
            throw new RuntimeException("No any booking record in the database");
        }
        return bookingTransformation.getAllBookingDTOs(allBookingEntities);
    }

    /**
     * get all the bookings between two days
     *
     * @param checkInDate
     * @param checkOutDate
     * @return
     */
    public List<BookingDTO> getBookingList(Date checkInDate, Date checkOutDate) {

        List<BookingEntity> bookingEntityList = new ArrayList<>();

        bookingRepository.findAllByCheckInDateGreaterThanEqualAndCheckOutDateIsLessThanEqual(checkInDate, checkOutDate).forEach(bookingEntityList::add);
        bookingRepository.findAllByCheckInDateLessThanAndCheckOutDateLessThan(checkInDate, checkOutDate).forEach(bookingEntityList::add);

        if (bookingEntityList.isEmpty()) {
            throw new RuntimeException("No Any booking between two days");
        }

        return bookingTransformation.getAllBookingDTOs(bookingEntityList);

    }


    /**
     * get a sigle booking DTO
     *
     * @param bookingId
     * @return
     */
    public BookingDetailsDTO getBooking(Integer bookingId) {

        BookingEntity bookingEntity = bookingRepository.findById(bookingId).get();

        return bookingTransformation.getBookingDetailsDTO(bookingEntity);

    }

    /**
     * update a booking
     *
     * @param bookingRequestDTO
     */
    public void updateBooking(BookingRequestDTO bookingRequestDTO) {
        if (bookingRequestDTO == null){
            throw  new RuntimeException(" null object has parsed");
        }
        bookingRepository.save(bookingTransformation.convertToBookingEntity(bookingRequestDTO));

    }

    /**
     * delete a booking
     *
     * @param bookingId
     * @return
     */
    public boolean deleteBooking(int bookingId) {

        if(bookingRepository.findById(bookingId).isPresent()){
            bookingRepository.deleteById(bookingId);
        }else {
            throw new RuntimeException("the Booking with the"+bookingId+"not existing");
        }

        return bookingRepository.existsById(bookingId);

    }

    /**
     * add a booking
     *
     * @param bookingRequestDTO
     */
    public void addBooking(BookingRequestDTO bookingRequestDTO) {

        if (bookingValidation.entityValidation(bookingRequestDTO)) {
            BookingEntity bookingEntity = bookingTransformation.convertToBookingEntity(bookingRequestDTO);
            bookingRepository.save(bookingEntity);
        } else {
            throw new RuntimeException("some details missing or not exists ");
        }

    }

    /**
     * update a contract
     *
     * @param contractRequestDTO
     */
    public void updateContract(ContractRequestDTO contractRequestDTO) {
        if (contractValidation.EntityValidation(contractRequestDTO)) {
            ContractEntity contractEntity = contractTransformation.convertToContractEntity(contractRequestDTO);
            contractRepository.save(contractEntity);
        } else {
            throw new RuntimeException("invalid or missing inputs");
        }
    }

    /**
     * get all the the contracts in a list
     *
     * @return
     */
    public List<ContractDTO> getAllContracts() {

        List<ContractEntity> allContractEntities = new ArrayList<>();

        contractRepository.findAll().forEach(allContractEntities::add);

        if (allContractEntities.isEmpty()){
             throw new RuntimeException("no contracts in the database");
        }

        return contractTransformation.convertToContractDTOS(allContractEntities);
    }

    /**
     * get a single contract
     *
     * @param contractId
     * @return
     */
    public ContractDTO getContract(Integer contractId) {
        ContractEntity contractEntity = contractRepository.findById(contractId).get();
        return contractTransformation.convertToContractDTO(contractEntity);
    }

    /**
     * add a a contract
     *
     * @param contractRequestDTO
     */
    public void addContract(ContractRequestDTO contractRequestDTO) {
        if (contractValidation.EntityValidation(contractRequestDTO)) {

            ContractEntity contractEntity = contractTransformation.convertToContractEntity(contractRequestDTO);
            contractRepository.save(contractEntity);

        } else {
            throw new RuntimeException("details missing or invalid ");
        }
    }

    /**
     * delete contract
     *
     * @param contractId
     * @return
     */
    public boolean deleteContract(int contractId) {
        contractRepository.deleteById(contractId);

        return contractRepository.existsById(contractId);
    }

    /**
     * get a list of all the guests
     *
     * @return
     */
    public List<GuestDTO> getAllGuests() {
        List<GuestEntity> allGuestEntityList = new ArrayList<>();
        guestRepository.findAll()
                .forEach(allGuestEntityList::add);

        return guestTransformation.convertToGuestDTO(allGuestEntityList);
    }

    /**
     * add a guest
     *
     * @param guestDTO
     */
    public void addGuest(GuestDTO guestDTO) {
        GuestEntity guestEntity = guestTransformation.convertToGuestEntity(guestDTO);
        guestRepository.save(guestEntity);
    }

    /**
     * update an existing guest
     *
     * @param guestDTO
     */
    public void updateGuest(GuestDTO guestDTO) {
        GuestEntity guestEntity = guestTransformation.convertToEntity(guestDTO);
        guestRepository.save(guestEntity);
    }

    /**
     * delete a guest
     *
     * @param guestId
     * @return
     */
    public boolean deleteGuest(int guestId) {

        guestRepository.deleteById(guestId);

        return !guestRepository.existsById(guestId);

    }

    /**
     * get a singel detailed guest
     *
     * @param guestId
     * @return
     */
    public SingleGuestDetailsDTO getGuestNew(int guestId) {
        GuestEntity guestEntity = guestRepository.findById(guestId).get();
        return guestTransformation.convertToSingleGuestFilterDTO(guestEntity);
    }

    /**
     * get all the hotels as a list
     *
     * @return
     */
    public List<HotelDTO> getAllHotels() {
        List<HotelEntity> allHotelEntities = new ArrayList<>();

        hotelRepository.findAll().forEach(allHotelEntities::add);

        return hotelTransformation.convertToHotelDTO(allHotelEntities);
    }

    /**
     * get a hotel
     *
     * @param hotelId
     * @return
     */
    public HotelDetailsDTO getHotel(Integer hotelId) {

        return hotelTransformation.convertToHotelDetailsDTO(hotelRepository.findById(hotelId).get());

    }

    /**
     * add a hotel to the database
     *
     * @param hotelEntity
     */
    public void addHotel(HotelEntity hotelEntity) {
        hotelRepository.save(hotelEntity);

    }

    /**
     * update a hotel
     *
     * @param hotelEntity
     */
    public void updateHotel(HotelEntity hotelEntity) {
        hotelRepository.save(hotelEntity);

    }

    /**
     * delete a hotel
     *
     * @param hotelId
     * @return
     */
    public boolean deleteHotel(int hotelId) {
        hotelRepository.deleteById(hotelId);

        return !hotelRepository.existsById(hotelId);
    }


    /**
     * add a room to the
     *
     * @param roomRequestDTO
     */
    public void addRoom(RoomRequestDTO roomRequestDTO) {
        if (roomValidation.validateEntity(roomRequestDTO)) {

//            RoomEntity roomEntity = roomRepository.findById(roomRequestDTO.getRoomId()).get();
            RoomEntity roomEntity = roomTransformation.convertToRoomEntity(roomRequestDTO);
           HotelEntity hotelEntity= hotelRepository.findById(roomRequestDTO.getHotelId()).get();
           roomEntity.setHotelEntity(hotelEntity);
            roomRepository.save(roomEntity);

        }

    }

    /**
     * get rooms
     *
     * @param hotelId
     * @return
     */
    public List<RoomDTO> getRooms(int hotelId) {
        List<RoomEntity> allRoomEntities = new ArrayList<>();
        hotelRepository.findById(hotelId).get().getRoomEntities().forEach(allRoomEntities::add);

        return roomTransformation.convertToRoomDTO(allRoomEntities);
    }

    /**
     * get all the users
     *
     * @return
     */
    public List<UserDTO> getAllUsers() {
        List<UserEntity> allUsers = new ArrayList<>();
        userRepository.findAll().forEach(allUsers::add);
        return userTransformation.convertToUserDTO(allUsers);
    }

    /**
     * add users
     *
     * @param userDTO
     */
    public void addUser(UserDTO userDTO) {
        UserEntity userEntity = userTransformation.convertToUserEntity(userDTO);
        userRepository.save(userEntity);
    }

    /**
     * update the users
     *
     * @param userDTO
     */
    public void updateUser(UserDTO userDTO) {
        UserEntity userEntity = userTransformation.convertToUserEntity(userDTO);
        userRepository.save(userEntity);
    }

    /**
     * delete user
     *
     * @param userId
     * @return
     */
    public boolean deleteUser(int userId) {
        userRepository.deleteById(userId);
        if (userRepository.findById(userId).isPresent()) {
            return false;
        }
        return true;
    }

    public void addContract1(ContractRequestDTONew contractRequestDTONew) {

        if(contractTransformation.userEntityValidation1(contractRequestDTONew.getUserID())){

            UserEntity userEntity = userRepository.findById(contractRequestDTONew.getUserID()).get();
          HotelEntity hotelEntity =  hotelTransformation.convertToHotelEntity1(contractRequestDTONew);
          hotelRepository.save(hotelEntity);
          ContractEntity contractEntity = contractTransformation.convertToContractEntity1(contractRequestDTONew);
            contractEntity.setUserEntity(userEntity);
            contractEntity.setHotelEntity(hotelEntity);
            contractRepository.save(contractEntity);
        }
        else
        {
            throw new RuntimeException("there is no user with the ID ");
        }


    }
}
