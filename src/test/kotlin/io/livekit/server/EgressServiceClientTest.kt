package io.livekit.server

import livekit.LivekitEgress
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

class EgressServiceClientTest {

    companion object {
        const val HOST = TestConstants.HOST
        const val KEY = TestConstants.KEY
        const val SECRET = TestConstants.SECRET

        val DEFAULT_OUTPUTS = EncodedOutputs(
            fileOutput = LivekitEgress.EncodedFileOutput.getDefaultInstance(),
            streamOutput = LivekitEgress.StreamOutput.getDefaultInstance(),
            segmentOutput = LivekitEgress.SegmentedFileOutput.getDefaultInstance(),
        )
    }

    lateinit var client: EgressServiceClient

    @BeforeTest
    fun setup() {
        client = EgressServiceClient.create(HOST, KEY, SECRET, true)
    }

    @Test
    fun listEgress() {
        val response = client.listEgress().execute()
        val body = response.body()
        assertTrue(response.isSuccessful)
        assertNotNull(body)
        assertTrue(body.isEmpty())
    }

    // sanity tests, only tests that requests are created without failing
    @Test
    fun startRoomCompositeEgressEncodedFile() {
        client.startRoomCompositeEgress(
            roomName = "room",
            output = LivekitEgress.EncodedFileOutput.getDefaultInstance()
        )
    }

    @Test
    fun startRoomCompositeEgressSegmented() {
        client.startRoomCompositeEgress(
            roomName = "room",
            output = LivekitEgress.SegmentedFileOutput.getDefaultInstance()
        )
    }

    @Test
    fun startRoomCompositeEgressStream() {
        client.startRoomCompositeEgress(
            roomName = "room",
            output = LivekitEgress.StreamOutput.getDefaultInstance()
        )
    }

    @Test
    fun startRoomCompositeEgressEncodedOutputs() {
        client.startRoomCompositeEgress(
            roomName = "room",
            output = DEFAULT_OUTPUTS
        )
    }

    @Test
    fun startTrackCompositeEgressEncodedFile() {
        client.startTrackCompositeEgress(
            roomName = "room",
            output = LivekitEgress.EncodedFileOutput.getDefaultInstance(),
            audioTrackId = "audio",
            videoTrackId = "video",
        )
    }

    @Test
    fun startTrackCompositeEgressSegmentedFile() {
        client.startTrackCompositeEgress(
            roomName = "room",
            output = LivekitEgress.SegmentedFileOutput.getDefaultInstance(),
            audioTrackId = "audio",
            videoTrackId = "video",
        )
    }

    @Test
    fun startTrackCompositeEgressStream() {
        client.startTrackCompositeEgress(
            roomName = "room",
            output = LivekitEgress.StreamOutput.getDefaultInstance(),
            audioTrackId = "audio",
            videoTrackId = "video",
        )
    }

    @Test
    fun startTrackCompositeEgressEncodedOutputs() {
        client.startTrackCompositeEgress(
            roomName = "room",
            output = DEFAULT_OUTPUTS,
            audioTrackId = "audio",
            videoTrackId = "video",
        )
    }

    @Test
    fun startWebEgressEncodedFile() {
        client.startWebEgress(
            url = "http://www.example.com",
            output = LivekitEgress.EncodedFileOutput.getDefaultInstance(),
        )
    }

    @Test
    fun startWebEgressSegmented() {
        client.startWebEgress(
            url = "http://www.example.com",
            output = LivekitEgress.SegmentedFileOutput.getDefaultInstance(),
        )
    }

    @Test
    fun startWebEgressStream() {
        client.startWebEgress(
            url = "http://www.example.com",
            output = LivekitEgress.StreamOutput.getDefaultInstance(),
        )
    }

    @Test
    fun startWebEgressEncodedOutputs() {
        client.startWebEgress(
            url = "http://www.example.com",
            output = DEFAULT_OUTPUTS,
        )
    }

}